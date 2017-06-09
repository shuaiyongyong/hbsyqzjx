package com.yc.sy.service;

import java.util.List;

import com.yc.sy.entity.User;

public interface UserService {

	boolean login(String uname, String upwd);

	User selectUser();

	boolean updateUser(User user);

	boolean telLogin(String utel);

	boolean checkTel(String utel);

	boolean mdTel(String utel);

}
