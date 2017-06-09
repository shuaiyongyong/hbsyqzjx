package com.yc.sy.service;

import java.util.List;

import com.yc.sy.entity.Knows;
import com.yc.sy.entity.PaginationBean;

public interface KnowService {

	List<Knows> selectAllKnows();

	List<Knows> singleKnows(int kid);

	boolean addKnows(Knows k);

	boolean removeKnows(int kid);

	boolean update(Knows ks);

	PaginationBean<Knows> getPartKnow(String pageSize, String currPage);

}
