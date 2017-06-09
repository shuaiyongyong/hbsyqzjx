package com.yc.sy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 直接响应字符串处理
	 * @param outStr
	 * @throws IOException
	 */
	protected void respOutStr(HttpServletResponse response, String outStr) throws IOException {
		PrintWriter out = response.getWriter();
		// out.println("<h1>wo</h1>");
		out.println(outStr);
		out.flush();
		out.close();
	}

	protected static String toJsonStr(Object obj) {
		//Gson gson = new Gson();
		
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(obj);
	}

	
	/**
	 * Class 为类 接口的类型,类似int为整型
	 * UserServlet.class 的类型是class,类似1的类型是int
	 * Class为类的抽象
	 */
	protected <T> T getReqParam2Obj(Request request, Class<T> clazz) {
		// 1.取到要转化成的对象的实例
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			LogManager.getLogger().error("创建失败:" + clazz.getName());
		}
		
		// clazz.getMethods();
		// 2.取到所有的请求参数名
		Enumeration<String> attrNames = request.getParameterNames();
		while (attrNames.hasMoreElements()) {
			String valName = (String) attrNames.nextElement();
			String val = request.getParameter(valName);

			// 3.根据请求参数名,通过反射取到对应的实体类中的方法对象
			String suff = String.format("et%c%s", Character.toUpperCase(valName.charAt(0)), valName.substring(1));
			try {
				Class<?> paramType = clazz.getMethod("g" + suff).getReturnType();// 取到getXxx()方法的返回类型对象
				java.lang.reflect.Method sm = clazz.getMethod("s" + suff, paramType);// 取到setXxx()方法对象
				
				try {
					if (paramType.getName().intern() == int.class.getName().intern()
							|| paramType.getName().intern() == Integer.class.getName().intern()) {
						sm.invoke(t, Integer.parseInt(val));// 方法类型是int和Integer
					} else if (paramType.getName().intern() == double.class.getName().intern()
							|| paramType.getName().intern() == Double.class.getName().intern()) {
						sm.invoke(t, Double.parseDouble(val));// 方法类型是double和Double
					} else {
						sm.invoke(t, val);//激活方法
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					LogManager.getLogger().warn("在"+clazz.getName()+"中,没有对应的方法"+e.getMessage());
				}

			} catch (NoSuchMethodException | SecurityException e) {
				LogManager.getLogger().warn(e.getMessage()+"传入的参数格式不正确,转化数据类型失败");
			}
		}
		return t;
	}
	
	protected <T> T getReqParam2Obj(HttpServletRequest request, Class<T> clazz) {
		// 1.取到要转化成的对象的实例
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			LogManager.getLogger().error("创建失败:" + clazz.getName());
		}
		
		// clazz.getMethods();
		// 2.取到所有的请求参数名
		Enumeration<String> attrNames = request.getParameterNames();
		while (attrNames.hasMoreElements()) {
			String valName = (String) attrNames.nextElement();
			String val = request.getParameter(valName);

			// 3.根据请求参数名,通过反射取到对应的实体类中的方法对象
			String suff = String.format("et%c%s", Character.toUpperCase(valName.charAt(0)), valName.substring(1));
			try {
				Class<?> paramType = clazz.getMethod("g" + suff).getReturnType();// 取到getXxx()方法的返回类型对象
				java.lang.reflect.Method sm = clazz.getMethod("s" + suff, paramType);// 取到setXxx()方法对象
				
				try {
					if (paramType.getName().intern() == int.class.getName().intern()
							|| paramType.getName().intern() == Integer.class.getName().intern()) {
						sm.invoke(t, Integer.parseInt(val));// 方法类型是int和Integer
					} else if (paramType.getName().intern() == double.class.getName().intern()
							|| paramType.getName().intern() == Double.class.getName().intern()) {
						sm.invoke(t, Double.parseDouble(val));// 方法类型是double和Double
					} else {
						sm.invoke(t, val);//激活方法
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					LogManager.getLogger().warn("在"+clazz.getName()+"中,没有对应的方法"+e.getMessage());
				}

			} catch (NoSuchMethodException | SecurityException e) {
				LogManager.getLogger().warn(e.getMessage()+"传入的参数格式不正确,转化数据类型失败");
			}
		}
		return t;
	}

	protected SmartUpload getSmartUpload(HttpServletRequest request, HttpServletResponse response){
		
		try {
			SmartUpload su=new SmartUpload();
			su.setCharset("utf-8");
			su.initialize(getServletConfig(),request,response);
			su.upload();
			return su;
		} catch (ServletException | IOException | SmartUploadException e) {
			e.printStackTrace();
		}
		return null;
	}
}
