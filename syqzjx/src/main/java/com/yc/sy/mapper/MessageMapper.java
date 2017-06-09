package com.yc.sy.mapper;

import java.util.List;

import com.yc.sy.entity.Message;

public interface MessageMapper {

	Message getMessage(int type);

	List<Message> listMessage();

	int removeMes(Integer mid);

	int doModify(Message message);

}
