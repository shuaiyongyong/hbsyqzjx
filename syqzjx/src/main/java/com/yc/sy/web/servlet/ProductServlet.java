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
import com.yc.sy.entity.PaginationBean;
import com.yc.sy.entity.ProductType;
import com.yc.sy.entity.Products;
import com.yc.sy.service.ProductService;

/**
 * Servlet implementation class Product
 */
@WebServlet("/product/*")
public class ProductServlet extends BaseServlet {

	private static final long serialVersionUID = -653646705139461970L;

	private ProductService productService;

	@Override
	public void init() throws ServletException {
		productService = (ProductService) cxt.getBean("productService");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUriStr = request.getRequestURI();
		LogManager.getLogger().debug("请求FavoriteServlet处理" + reqUriStr + "的请求资源....");
		if (reqUriStr.endsWith("allTypeList")) {
			doAllTypeList(request,response);
		}else if (reqUriStr.endsWith("list")) {
			doList(request,response);
		}else if (reqUriStr.endsWith("typeList")) {
			doTypeList(request,response);
		}else if (reqUriStr.endsWith("selectType")) {
			doSelectType(request,response);
		}else if (reqUriStr.endsWith("selectPic")) {
			doSelectPic(request,response);
		}else if (reqUriStr.endsWith("selectTypeByName")) {
			doSelectTypeByName(request,response);
		}else if (reqUriStr.endsWith("addProductType")) {
			doAddProductType(request,response);
		}else if (reqUriStr.endsWith("modifyType")) {
			doModifyProductType(request,response);
		}else if (reqUriStr.endsWith("selectTypeByPtid")) {
			doSelectTypeByPtid(request,response);
		}else if (reqUriStr.endsWith("addProduct")) {
			doAddProduct(request,response);
		}else if (reqUriStr.endsWith("selectProductByName")) {
			doSelectProductByName(request,response);
		}else if (reqUriStr.endsWith("modifyProduct")) {
			doModifyProduct(request,response);
		}
	}

	private void doModifyProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SmartUpload su = getSmartUpload(request,response);
		Request req = su.getRequest();
		//去上传文件
		File f = su.getFiles().getFile(0);
		if(!f.isMissing()){
			String path =new java.io.File(getServletContext().getRealPath("/")).getParent() + "\\upload\\" + f.getFileName();
			try {
				f.saveAs(path, SmartUpload.SAVE_PHYSICAL);
			} catch (SmartUploadException | IOException e) {
				e.printStackTrace();
			}
		}
		Products ps = new Products();
		String pname = req.getParameter("pname");
		String pid =req.getParameter("pid");
		String pbrife = req.getParameter("pbrife");	
		String ptid = req.getParameter("ptid");
		ps.setPid(Integer.parseInt(pid));
		ps.setPtid(Integer.parseInt(ptid));
		ps.setPname(pname);
		ps.setPpic("/upload/" + f.getFileName());
		ps.setPbrife(pbrife);
		boolean isSuccess = productService.ModifyProduct(ps);
		respOutStr(response, isSuccess + "");
	}

	private void doTypeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pageSize = request.getParameter("rows");//页面大小
		String currPage = request.getParameter("page");//当前页数

		PaginationBean<ProductType> productTypeBean = productService.getPartProductType(pageSize,currPage);//分页数据 
		respOutStr(response, toJsonStr(productTypeBean));
	}

	private void doSelectProductByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pname = request.getParameter("apname");
		boolean isSuccess = productService.SelectProductByName(pname);
		respOutStr(response, isSuccess + "");
	}

	private void doAddProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SmartUpload su = getSmartUpload(request,response);
		Request req = su.getRequest();
		//去上传文件
		File f = su.getFiles().getFile(0);
		if(!f.isMissing()){
			String path =new java.io.File(getServletContext().getRealPath("/")).getParent() + "\\upload\\" + f.getFileName();
			try {
				f.saveAs(path, SmartUpload.SAVE_PHYSICAL);
			} catch (SmartUploadException | IOException e) {
				e.printStackTrace();
			}
		}
		String tid = req.getParameter("aptid");
		int ptid = Integer.parseInt(tid);
		String pname = req.getParameter("apname");
		String pbrife = req.getParameter("apbrife");
		Products ps = new Products();
		ps.setPbrife(pbrife);
		ps.setPname(pname);
		ps.setPpic("/upload/" + f.getFileName());
		ps.setPtid(ptid);
		
		boolean isSuccess = productService.AddProduct(ps);
		respOutStr(response, isSuccess + "");
	}

	private void doSelectTypeByPtid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("ptid");
		int ptid =Integer.parseInt(id);
		List<ProductType> pts = productService.selectTypeByPtid(ptid);
		respOutStr(response, toJsonStr(pts));
	}

	private void doModifyProductType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductType pt = new ProductType();
		String ptname = request.getParameter("ptyname");
		String ptid =request.getParameter("ptyid");
		System.out.println(ptname);
		pt.setPtid(Integer.parseInt(ptid));
		pt.setPtname(ptname);
		boolean isCan = productService.SelectTypeByName(ptname);//表示有重名
		if (isCan) {
			respOutStr(response,false+"");
		}else{
		boolean isSuccess = productService.ModifyProductType(pt);
		respOutStr(response, isSuccess + "");
		}
	}

	private void doAddProductType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductType pt = getReqParam2Obj(request,ProductType.class);
		System.out.println("===>"+pt);
		boolean isSuccess = productService.AddProductType(pt);
		respOutStr(response, isSuccess + "");
	}

	private void doSelectTypeByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ProductType pt=getReqParam2Obj(request, ProductType.class);
		System.out.println("ptname"+pt.getPtname());
		boolean isCan = productService.SelectTypeByName(pt.getPtname());
		respOutStr(response, isCan + "");
	}

	private void doSelectPic(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("pid");
		int pid = Integer.parseInt(id);
		List<Products> pt = productService.SingleSelect(pid);
		respOutStr(response, toJsonStr(pt));
	}

	private void doSelectType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("ptid");
		int ptid = Integer.parseInt(id);
		List<Products> pt = productService.Select(ptid);
		respOutStr(response, toJsonStr(pt));

	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("ptid");
		if(id != null){
			int ptid = Integer.parseInt(id);
			String pageSize = request.getParameter("rows");//页面大小
			String currPage = request.getParameter("page");//当前页数
			PaginationBean<Products> productBean = productService.getPartProducts(pageSize,currPage,ptid);//分页数据 
			respOutStr(response, toJsonStr(productBean));
		}else{		
			String pageSize = request.getParameter("rows");//页面大小
			String currPage = request.getParameter("page");//当前页数

			PaginationBean<Products> productBean = productService.getPartProduct(pageSize,currPage);//分页数据 
			respOutStr(response, toJsonStr(productBean));
		}
	}

	private void doAllTypeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ProductType> pts = productService.typeList();
		respOutStr(response, toJsonStr(pts));
	}

}
