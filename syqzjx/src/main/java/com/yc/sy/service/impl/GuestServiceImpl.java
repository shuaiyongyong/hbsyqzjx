package com.yc.sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.sy.entity.Guest;
import com.yc.sy.mapper.GuestMapper;
import com.yc.sy.service.GuestService;

@Service("guestService")
public class GuestServiceImpl implements GuestService {
	
	@Autowired
	private GuestMapper guestMapper;
	@Override
	public boolean insert(Guest guest) {
	
		return guestMapper.insertGuest(guest)>0;
	}
	@Override
	public List<Guest> listGuest() {
		// TODO Auto-generated method stub
		return guestMapper.listGuest();
	}
	@Override
	public boolean deleteMes(Integer gid) {
		// TODO Auto-generated method stub
		return guestMapper.deleteMes(gid)>0;
	}
	@Override
	public Guest getMesById(Integer gid) {
		// TODO Auto-generated method stub
		return guestMapper.getMesById(gid);
	}

}
