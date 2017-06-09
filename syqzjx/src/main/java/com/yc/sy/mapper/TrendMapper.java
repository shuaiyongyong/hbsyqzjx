package com.yc.sy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.sy.entity.Trends;

public interface TrendMapper {

	List<Trends> selectTrend();

	List<Trends> singleNews(int tid);

	List<Trends> getPartTrends(@Param("start") int start,@Param("end") int end);

	int getTotalPage(int pageSize);

	int addTrend(Trends ts);

	boolean remove(int tid);

	int update(Trends ts);

}
