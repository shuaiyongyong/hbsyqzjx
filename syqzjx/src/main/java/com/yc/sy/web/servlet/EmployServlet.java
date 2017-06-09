package com.yc.sy.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yc.sy.entity.Employ;
import com.yc.sy.service.EmployService;
import com.yc.sy.util.ServiceUtil;




/**
 * Servlet implementation class ZzzsServlet
 */
@WebServlet("/employ/*")
public class EmployServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private EmployService employService;
	public EmployServlet() {
		employService=(EmployService) cxt.getBean("employService");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriName=ServiceUtil.getPath(request.getRequestURI());
		switch (uriName) {
		case "all":	//获取资质证书getdescription
			doGetAll(request, response);
			break;
		case "getdescription":	//获取资质证书getdescription
			doGetDescription(request, response);
			break;
		case "list":
			doList(request,response);
			break;
		case "listById":
			doListById(request,response);
			break;
		case "modify":
			doModify(request,response);
			break;
		case "delJob":
			doDelJob(request,response);
			break;
		case "addJob":
			doAddJob(request,response);
			break;
		default:
			break;
		}
	}
	private void doAddJob(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employ employ=getReqParam2Obj(request, Employ.class);
		boolean result=employService.AddJob(employ);
		respOutStr(response,result+"");
	}

	private void doDelJob(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int eid=Integer.parseInt(request.getParameter("eid"));
		boolean result=employService.removeJob(eid);
		respOutStr(response,result+"");
	}

	private void doModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employ employ=getReqParam2Obj(request, Employ.class);
		boolean result=employService.modifyJob(employ);
		respOutStr(response,result+"");
	}

	private void doListById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int eid=Integer.parseInt(request.getParameter("eid"));
		Employ employ=employService.findEmployById(eid);
		respOutStr(response,toJsonStr(employ));
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Employ> employs=employService.findAllEmploy();
		respOutStr(response,toJsonStr(employs));
	}
	
	private void doGetDescription(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int eid=Integer.parseInt(request.getParameter("eid").toString());
		Employ employ=employService.getDescrtiption(eid);
		respOutStr(response, toJsonStr(employ));
		
	}
	private void doGetAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Employ> employs=employService.getAll();
		respOutStr(response, toJsonStr(employs));
		
	}

}
