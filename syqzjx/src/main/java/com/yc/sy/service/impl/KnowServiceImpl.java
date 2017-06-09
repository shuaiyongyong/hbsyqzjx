package com.yc.sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.sy.entity.Knows;
import com.yc.sy.entity.PaginationBean;
import com.yc.sy.mapper.KnowMapper;
import com.yc.sy.service.KnowService;

@Service("knowService")
public class KnowServiceImpl implements KnowService {

	@Autowired
	private KnowMapper knowMapper;
	
	@Override
	public List<Knows> selectAllKnows() {
		return knowMapper.selectAllKnows();
	}

	@Override
	public List<Knows> singleKnows(int kid) {
		return knowMapper.singleKnows(kid);
	}


	@Override
	public boolean addKnows(Knows k) {
		return knowMapper.addKnows(k) >0;
	}

	@Override
	public boolean removeKnows(int kid) {
		return knowMapper.removeKnows(kid) >0;
	}

	@Override
	public boolean update(Knows ks) {
		return knowMapper.update(ks) >0;
	}

	@Override
	public PaginationBean<Knows> getPartKnow(String size, String page) {
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
		
		List<Knows> knows = knowMapper.getPartKnows(start,end);
		return new PaginationBean<Knows>(currPage, totalPage, knows,pageSize * totalPage);
	}

	private int getTotalPage(int pageSize) {
		return knowMapper.getTotalPage(  pageSize);
	}
}
