package com.yc.sy.service;

import java.util.List;

import com.yc.sy.entity.Message;

public interface MessageService {

	Message getMessage(int type);

	List<Message> list();

	boolean RemoveMes(Integer mid);

	boolean doMoidfy(Message message);

}
