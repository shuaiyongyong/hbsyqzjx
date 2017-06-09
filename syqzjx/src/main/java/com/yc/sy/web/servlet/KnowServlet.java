package com.yc.sy.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.sy.entity.Knows;
import com.yc.sy.entity.PaginationBean;
import com.yc.sy.service.KnowService;

/**
 * Servlet implementation class Know
 */
@WebServlet("/know/*")
public class KnowServlet extends BaseServlet {

	private static final long serialVersionUID = 5365027642006773900L;
	
	private KnowService knowService;
	
	@Override
	public void init() throws ServletException {
		knowService = (KnowService) cxt.getBean("knowService");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUriStr = request.getRequestURI();
		if (reqUriStr.endsWith("list")) {
			doList(request,response);
		}else if(reqUriStr.endsWith("selectKnows")){
			doSelectKnows(request,response);
		}else if(reqUriStr.endsWith("addKnow")){
			doAddKnows(request,response);
		}else if(reqUriStr.endsWith("remove")){
			doRemove(request,response);
		}else if(reqUriStr.endsWith("update")){
			doUpdate(request,response);
		}
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Knows ks = new Knows();
		String id= request.getParameter("kid");
		int kid = Integer.parseInt(id);
		String ktag = request.getParameter("ktag");
		String kcontent = request.getParameter("kcontent");
		ks.setKcontent(kcontent);
		ks.setKtag(ktag);
		ks.setKid(kid);
		boolean isSuccess = knowService.update(ks);
		respOutStr(response, isSuccess +"");
		
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String kids = request.getParameter("kid");
		int kid = Integer.parseInt(kids);
		boolean isSuccess = knowService.removeKnows(kid);
		respOutStr(response, isSuccess + "");
	}

	private void doAddKnows(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Knows k = new Knows();
		String ktag = request.getParameter("ktag");
		String kcontent = request.getParameter("kcontent");
		k.setKcontent(kcontent);
		k.setKtag(ktag);
		boolean isSuccess = knowService.addKnows(k);
		respOutStr(response, isSuccess + "");
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pageSize = request.getParameter("rows");//页面大小
		String currPage = request.getParameter("page");//当前页数
		PaginationBean<Knows>knowBean =knowService.getPartKnow(pageSize,currPage);//分页数据 
		respOutStr(response, toJsonStr(knowBean));
	}

	private void doSelectKnows(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("kid");
		int kid = Integer.parseInt(id);
		List<Knows> ks = knowService.singleKnows(kid);
		respOutStr(response, toJsonStr(ks));
		
	}

}
