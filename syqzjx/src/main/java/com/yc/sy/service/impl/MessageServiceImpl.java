package com.yc.sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.sy.entity.Message;
import com.yc.sy.mapper.MessageMapper;
import com.yc.sy.service.MessageService;
@Service("messageService")
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageMapper messageMapper;
	@Override
	public Message getMessage(int type) {
		return messageMapper.getMessage(type);
	}
	@Override
	public List<Message> list() {
		return messageMapper.listMessage();
	}
	@Override
	public boolean RemoveMes(Integer mid) {
		return messageMapper.removeMes(mid)>0;
	}
	@Override
	public boolean doMoidfy(Message message) {
		return messageMapper.doModify(message)>0;
	}

}
