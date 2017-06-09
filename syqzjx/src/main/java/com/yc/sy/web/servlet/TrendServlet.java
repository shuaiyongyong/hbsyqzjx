package com.yc.sy.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.sy.entity.PaginationBean;
import com.yc.sy.entity.Trends;
import com.yc.sy.service.TrendService;

/**
 * Servlet implementation class Trend
 */
@WebServlet("/trend/*")
public class TrendServlet extends BaseServlet {
	
	private static final long serialVersionUID = 849067263039484450L;
	
	private TrendService trendService;
	
	@Override
	public void init() throws ServletException {
		trendService = (TrendService) cxt.getBean("trendService");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUriStr = request.getRequestURI();
		if (reqUriStr.endsWith("list")) {
			doList(request,response);
		}else if (reqUriStr.endsWith("selectNews")) {
			doSelectNews(request,response);
		}else if (reqUriStr.endsWith("addTrend")) {
			doAddTrend(request,response);
		}else if(reqUriStr.endsWith("remove")){
			doRemove(request,response);
		}else if(reqUriStr.endsWith("update")){
			doUpdate(request,response);
		}
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Trends ts = new Trends();
		String id= request.getParameter("tid");
		int tid = Integer.parseInt(id);
		String ttag = request.getParameter("ttag");
		String tcontent = request.getParameter("tcontent");
		ts.setTcontent(tcontent);
		ts.setTid(tid);
		ts.setTtag(ttag);
		boolean isSuccess = trendService.update(ts);
		respOutStr(response, isSuccess +"");
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String id = request.getParameter("tid");
			int tid = Integer.parseInt(id);
			boolean isSuccess = trendService.remove(tid);
			respOutStr(response, isSuccess + "");
	}

	private void doAddTrend(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Trends ts = new Trends();
		String ttag = request.getParameter("ttag");
		String tcontent = request.getParameter("tcontent");
		ts.setTcontent(tcontent);
		ts.setTtag(ttag);
		boolean isSuccess =trendService.addTrend(ts);
		respOutStr(response, isSuccess + "");
		
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pageSize = request.getParameter("rows");//页面大小
		String currPage = request.getParameter("page");//当前页数
		
		PaginationBean<Trends> trendBean = trendService.getPartTrend(pageSize,currPage);//分页数据 
		respOutStr(response, toJsonStr(trendBean));
	}

	private void doSelectNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("tid");
		int tid = Integer.parseInt(id);
		List<Trends> ts = trendService.singleNews(tid);
		respOutStr(response, toJsonStr(ts));
	}

}
