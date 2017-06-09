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
import com.yc.sy.entity.Context;
import com.yc.sy.service.CompanyService;
import com.yc.sy.util.ServletUtil;

@WebServlet("/contect/*")
public class ContectServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private CompanyService companyService;
	@Override
	public void init() throws ServletException {
		companyService=(CompanyService) cxt.getBean("companyService");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriName=ServletUtil.getUriName(request.getRequestURI());
		LogManager.getLogger().debug("请求ContectServlet处理"+uriName+"的请求资源...");
		switch(uriName){
		case "list":
			doList(request,response);
			break;
		case "list1":
			doList1(request,response);
			break;
		case "getCconcrete":
			doGetCconcrete(request,response);
			break;
		case "changeCconcrete":
			doChangeCconcrete(request,response);
			break;
		case "changeCconcrete1":
			doChangeCconcrete1(request,response);
			break;
		case "delZzzs":
			doDelZzzs(request,response);
			break;
		case "sczs":
			doAddZzzs(request,response);
			break;
		}
	}

	

	private void doAddZzzs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SmartUpload su=getSmartUpload(request, response);
		Request req = su.getRequest( );
		//上传文件数据
		File f = su.getFiles().getFile(0);
		if(!f.isMissing()){
			String path=new java.io.File (getServletContext().getRealPath("/")).getParent()+"\\upload\\"+f.getFileName();
			System.out.println(path);
			try {
				//保存到服务器
				f.saveAs(path, SmartUpload.SAVE_PHYSICAL);
			} catch (SmartUploadException | IOException e) {
				LogManager.getLogger().error("资格证书上传失败!!!",e);
			}
		}
		Context context=new Context();
		context.setCconcrete("/upload/"+f.getFileName());
		context.setCtype(5);
		boolean result=companyService.addZzzs(context);
		respOutStr(response, toJsonStr(result));
	}

	private void doDelZzzs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cid=Integer.parseInt(request.getParameter("cid"));
		boolean result=companyService.delZzzs(cid);
		respOutStr(response, toJsonStr(result));
	}

	private void doChangeCconcrete1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cid=request.getParameter("cid");
		Context context=getReqParam2Obj(request, Context.class);
		context.setCid(Integer.parseInt(cid));
		boolean result=companyService.changeCconcrete(context);
		respOutStr(response, toJsonStr(result));
	}

	private void doChangeCconcrete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cid=request.getParameter("cid");
		SmartUpload su=getSmartUpload(request, response);
		Request req = su.getRequest( );
		//上传文件数据
		File f = su.getFiles().getFile(0);
		if(!f.isMissing()){
			String path=new java.io.File (getServletContext().getRealPath("/")).getParent()+"\\upload\\"+f.getFileName();
			System.out.println(path);
			try {
				//保存到服务器
				f.saveAs(path, SmartUpload.SAVE_PHYSICAL);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
		}
		Context context=new Context();
		context.setCconcrete("/upload/"+f.getFileName());
		context.setCid(Integer.parseInt(cid));
		boolean result=companyService.changeCconcrete(context);
		respOutStr(response, toJsonStr(result));
	}

	private void doGetCconcrete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cid=request.getParameter("cid");
		Context context1=new Context();
		context1.setCid(Integer.parseInt(cid));
		Context context2=companyService.findContextByCid(context1);
		respOutStr(response,toJsonStr(context2));
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Context> contexts=companyService.findContextByType1();
		respOutStr(response,toJsonStr(contexts));
	}
	private void doList1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Context> contexts=companyService.findContextByType2();
		respOutStr(response,toJsonStr(contexts));
	}

}
