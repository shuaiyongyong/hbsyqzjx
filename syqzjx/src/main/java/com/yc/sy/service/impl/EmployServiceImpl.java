package com.yc.sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.sy.entity.Employ;
import com.yc.sy.mapper.EmployMapper;
import com.yc.sy.service.EmployService;


@Service("employService")
public class EmployServiceImpl implements EmployService {
	@Autowired
	private EmployMapper employMapper;
	@Override
	public List<Employ> getAll() {
		// TODO Auto-generated method stub
		return employMapper.getAll();
	}
	@Override
	public Employ getDescrtiption(int eid) {
		
		return employMapper.getDescription(eid);
	}
	
	@Override
	public List<Employ> findAllEmploy() {
		return employMapper.selectAllEmploy();
	}

	@Override
	public Employ findEmployById(int eid) {
		return employMapper.selectEmployById(eid);
	}

	@Override
	public boolean modifyJob(Employ employ) {
		return employMapper.updateJob(employ)>0;
	}

	@Override
	public boolean removeJob(int eid) {
		return employMapper.delJob(eid)>0;
	}

	@Override
	public boolean AddJob(Employ employ) {
		return employMapper.insertEmploy(employ)>0;
	}


}
