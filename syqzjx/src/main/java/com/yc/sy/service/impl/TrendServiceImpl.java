package com.yc.sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.sy.entity.PaginationBean;
import com.yc.sy.entity.Trends;
import com.yc.sy.mapper.TrendMapper;
import com.yc.sy.service.TrendService;

@Service("trendService")
public class TrendServiceImpl implements TrendService {
	
	@Autowired
	private TrendMapper trendMapper;

	@Override
	public List<Trends> trendList() {
		return trendMapper.selectTrend();
	}

	@Override
	public List<Trends> singleNews(int tid) {
		return trendMapper.singleNews(tid);
	}

	@Override
	public PaginationBean<Trends> getPartTrend(String size, String page) {
		int currPage = 1;//默认当前页为第一页
		int pageSize = 12;//默认页面条数为12条
		if (size != null) {
			pageSize = Integer.parseInt(size);//取到"真实"的页面条数
		}
		int totalPage = getTotalPage(pageSize);
		if (page != null) {
			currPage = Integer.parseInt(page);
			if (currPage > totalPage) {//最后一页
				currPage = totalPage;
			} else if (currPage < 1) {//第一页
				currPage = 1;
			}
		}
		int start = (currPage-1)*pageSize;
				
		int end =pageSize;
		
		List<Trends> trends = trendMapper.getPartTrends(start,end);
		return new PaginationBean<Trends>(currPage, totalPage, trends,pageSize * totalPage);
	}

	private int getTotalPage(int pageSize) {
		return trendMapper.getTotalPage(  pageSize);
	}

	@Override
	public boolean addTrend(Trends ts) {
		return trendMapper.addTrend(ts) >0;
	}

	@Override
	public boolean remove(int tid) {
		return trendMapper.remove(tid);
	}

	@Override
	public boolean update(Trends ts) {
		return trendMapper.update(ts) >0;
	}


}
