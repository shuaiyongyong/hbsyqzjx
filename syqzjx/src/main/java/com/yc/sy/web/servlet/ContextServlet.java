package com.yc.sy.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yc.sy.entity.Context;
import com.yc.sy.service.ContextService;
import com.yc.sy.util.ServiceUtil;



/**
 * Servlet implementation class ZzzsServlet
 */
@WebServlet("/context/*")
public class ContextServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ContextService contextService;
	
	@Override
	public void init() throws ServletException {
		contextService=(ContextService) cxt.getBean("contextService");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriName=ServiceUtil.getPath(request.getRequestURI());
		switch (uriName) {
		case "zs":	//获取资质证书
			doGetZs(request, response);
			break;
		case "all":	//获取资质证书
			doGetAll(request, response);
			break;

		default:
			break;
		}
	}
	
	private void doGetAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Context> contexts=contextService.getAll();
		respOutStr(response, toJsonStr(contexts));
		
	}
	private void doGetZs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Context> contexts=contextService.getZs();
		respOutStr(response, toJsonStr(contexts));
		
	}

}
