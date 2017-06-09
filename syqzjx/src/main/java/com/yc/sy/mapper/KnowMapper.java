package com.yc.sy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.sy.entity.Knows;

public interface KnowMapper {

	List<Knows> selectAllKnows();

	List<Knows> singleKnows(int kid);

	List<Knows> getPartKnows(@Param("start") int start,@Param("end") int end);

	int getTotalPage(int pageSize);

	int addKnows(Knows k);

	int removeKnows(int kid);

	int update(Knows ks);

}
