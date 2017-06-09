package com.yc.sy.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yc.sy.entity.Company;
import com.yc.sy.entity.Context;
import com.yc.sy.entity.Knows;
import com.yc.sy.entity.ProductType;
import com.yc.sy.service.CompanyService;
import com.yc.sy.util.ServletUtil;

@WebServlet("/cominfo/*")
public class CompanyServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private CompanyService companyService;
	@Override
	public void init() throws ServletException {
		companyService=(CompanyService) cxt.getBean("companyService");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriName=ServletUtil.getUriName(request.getRequestURI());
		LogManager.getLogger().debug("请求CompanyServlet处理"+uriName+"的请求资源...");
		switch(uriName){
		case "list":
			doList(request,response);
			break;
		case "listProductType":
			doListType(request,response);
			break;
		case "listKnow":
			doListKnow(request,response);
			break;
		case "listContect":
			doListContect(request,response);
			break;
		case "changeIntro":
			doChangeIntro(request,response);
			break;
		case "changeLogo":
			doChangeLogo(request,response);
			break;
		}
	}

	private void doChangeLogo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String syqzjx = request.getContextPath();//发布的项目名
		SmartUpload su=getSmartUpload(request, response);
		Request req = su.getRequest( );
		//上传文件数据
		File f = su.getFiles().getFile(0);
		if(!f.isMissing()){
			String path=new java.io.File (getServletContext().getRealPath("/")).getParent()+"\\upload\\"+f.getFileName();
			try {
				//保存到服务器
				f.saveAs(path, SmartUpload.SAVE_PHYSICAL);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
		}
		Company company=new Company();
		company.setCbrand("/upload/"+f.getFileName());
		boolean result=companyService.changeLogo(company);
		respOutStr(response, toJsonStr(result));
	}

	private void doChangeIntro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Company company=getReqParam2Obj(request, Company.class);
		boolean isSuccess=companyService.changeComIntro(company);
		respOutStr(response,isSuccess+"");
	}

	private void doListContect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String ctype=request.getParameter("ctype");
		Context context=new Context();
		context.setCtype(Integer.parseInt(ctype));
		List<Context> contexts=companyService.findContextByType(context);
		respOutStr(response,toJsonStr(contexts));
	}


	private void doListKnow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Knows> knows=companyService.findKnows();
		respOutStr(response,toJsonStr(knows));
	}

	private void doListType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ProductType> productType=companyService.findProductType();
		respOutStr(response,toJsonStr(productType));
		
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Company compony=companyService.findComInfo();
		respOutStr(response,toJsonStr(compony));
	}


}
