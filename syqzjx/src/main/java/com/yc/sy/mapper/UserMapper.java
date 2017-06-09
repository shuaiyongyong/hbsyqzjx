package com.yc.sy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.sy.entity.User;

public interface UserMapper {

	Object findUser(@Param("uname")String uname,@Param("upwd") String upwd);

	User selectUser();

	int updateUser(User user);

	int telLogin(String utel);

	Object checkTel(String utel);

	int mdTel(String utel);

}
