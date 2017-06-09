package com.yc.sy.service;

import java.util.List;

import com.yc.sy.entity.Guest;

public interface GuestService {

	boolean insert(Guest guest);

	List<Guest> listGuest();

	boolean deleteMes(Integer gid);

	Guest getMesById(Integer gid);
	
}
