package com.yc.sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.sy.entity.User;
import com.yc.sy.mapper.UserMapper;
import com.yc.sy.service.UserService;
import com.yc.sy.util.Encrypt;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;


	@Override
	public boolean login(String uname, String upwd) {
		upwd = Encrypt.md5AndSha(upwd); //加密操作
		return userMapper.findUser(uname,upwd) !=null;
	}


	@Override
	public User selectUser() {
		return userMapper.selectUser();
	}


	@Override
	public boolean updateUser(User user) {
		return userMapper.updateUser(user) >0;
	}


	@Override
	public boolean telLogin(String utel) {
		return userMapper.telLogin(utel) >0;
	}


	@Override
	public boolean checkTel(String utel) {
		return userMapper.checkTel(utel)!=null;
	}


	@Override
	public boolean mdTel(String utel) {
		return userMapper.mdTel(utel) >0;
	}
}
