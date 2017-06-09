package com.yc.sy.service;

import java.util.List;

import com.yc.sy.entity.PaginationBean;
import com.yc.sy.entity.Trends;

public interface TrendService {

	List<Trends> trendList();

	List<Trends> singleNews(int tid);

	PaginationBean<Trends> getPartTrend(String pageSize, String currPage);

	boolean addTrend(Trends ts);

	boolean remove(int tid);

	boolean update(Trends ts);

}
