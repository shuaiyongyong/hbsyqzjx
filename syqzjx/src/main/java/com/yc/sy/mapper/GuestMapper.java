package com.yc.sy.mapper;

import java.util.List;

import com.yc.sy.entity.Guest;

public interface GuestMapper {
	
	public List<Guest> getGuest();

	public int insertGuest(Guest guest);

	public List<Guest> listGuest();

	public int deleteMes(Integer gid);

	public Guest getMesById(Integer gid);
}
