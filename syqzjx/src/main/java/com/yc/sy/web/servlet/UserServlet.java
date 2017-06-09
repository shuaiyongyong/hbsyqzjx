package com.yc.sy.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.sy.entity.User;
import com.yc.sy.service.UserService;
import com.yc.sy.util.Encrypt;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
	
	private static final long serialVersionUID = -1013887083014618172L;
	
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = (UserService) cxt.getBean("userService");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUriStr = request.getRequestURI();
		if (reqUriStr.endsWith("numLogin")) {
			doNumLogin(request,response);
		}else if(reqUriStr.endsWith("telLogin")){
			doTelLogin(request,response);
		}else if(reqUriStr.endsWith("selectUser")){
			doSelectUser(request,response);
		}else if(reqUriStr.endsWith("update")){
			doUpdateUser(request,response);
		}else if(reqUriStr.endsWith("checkTel")){
			doCheckTel(request,response);
		}else if(reqUriStr.endsWith("checkCode")){
			doCheckCode(request,response);
		}else if(reqUriStr.endsWith("mdTel")){
			doMdTel(request,response);
		}
	}

	private void doMdTel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String utel=request.getParameter("mutel");
		boolean issucces=userService.mdTel(utel);
		respOutStr(response, issucces+"");
	}

	//手机验证码登录,为以防万一，做手机号验证
	private void doCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String utel=request.getParameter("utel");
		String rCode=request.getParameter("text");
		String sCode=null;
		
		if(request.getSession().getAttribute("code")==null){
			request.getSession().setAttribute("errorMsg", "验证码还未发送...");
			response.sendRedirect("../page/login.jsp");
			return;
		}else{
			sCode=request.getSession().getAttribute("code").toString();
		}
		
		if(userService.checkTel(utel) && rCode.intern()==sCode.intern()){
			request.getSession().setAttribute("loginUser", "Admin");
			response.sendRedirect("../back/admin.jsp");
		}else{
			request.getSession().setAttribute("errorMsg", "验证码错误...");
			response.sendRedirect("../page/login.jsp");
		}
	}

	private void doCheckTel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String utel=request.getParameter("utel");
		boolean isTel=userService.checkTel(utel);
		respOutStr(response, isTel+"");
	}

	private void doTelLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String utel = request.getParameter("utel");
		boolean issucces = userService.telLogin(utel);
		respOutStr(response, issucces +"");
	}

	private void doUpdateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String id = request.getParameter("usid");
			int usid = Integer.parseInt(id);
			String pwd = request.getParameter("upwd");
			String upwd =Encrypt.md5AndSha(pwd);
			String utel = request.getParameter("utel");
			User user = new User();
			user.setUpwd(upwd);
			user.setUsid(usid);
			user.setUtel(utel);
			boolean issucces = userService.updateUser(user);
			respOutStr(response, issucces +"");
	}

	private void doSelectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = userService.selectUser();
		respOutStr(response, toJsonStr(user));
	}

	private void doNumLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		boolean issucces = userService.login(uname,upwd);
		if(issucces){
			request.getSession().setAttribute("loginUser", uname);
			response.sendRedirect("../back/admin.jsp");
		}else{
			request.getSession().setAttribute("errorMsg", "用户名或密码错误...");
			response.sendRedirect("../page/login.jsp");
		}
		
	}

}
