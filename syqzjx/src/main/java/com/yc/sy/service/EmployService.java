package com.yc.sy.service;

import java.util.List;

import com.yc.sy.entity.Employ;

public interface EmployService {

	List<Employ> getAll();

	Employ getDescrtiption(int eid);
	
	List<Employ> findAllEmploy();

	Employ findEmployById(int eid);

	boolean modifyJob(Employ employ);

	boolean removeJob(int eid);

	boolean AddJob(Employ employ);

}
