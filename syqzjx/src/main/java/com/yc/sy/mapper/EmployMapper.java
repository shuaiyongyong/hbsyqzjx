package com.yc.sy.mapper;

import java.util.List;

import com.yc.sy.entity.Employ;

public interface EmployMapper {

	List<Employ> getAll();

	Employ getDescription(int eid);
		
	List<Employ> selectAllEmploy();

	Employ selectEmployById(int eid);

	int updateJob(Employ employ);

	int delJob(int eid);

	int insertEmploy(Employ employ);
}
