package com.yc.sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.sy.entity.Context;
import com.yc.sy.mapper.ContextMapper;
import com.yc.sy.service.ContextService;

@Service("contextService")
public class ContextServiceImpl implements ContextService {

	@Autowired
	private ContextMapper contextMapper;
	@Override
	public List<Context> getZs() {

		return contextMapper.getZs();
	}
	@Override
	public List<Context> getAll() {
		return contextMapper.getAll();
	}

}
