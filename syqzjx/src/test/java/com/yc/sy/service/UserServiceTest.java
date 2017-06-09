package com.yc.sy.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.sy.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceTest {

	@Autowired
	private UserService us;
	
	@Test
	public void testLogin() {
		boolean result = us.login("Admin","a");
		assertEquals(true, result);
	}

	@Test
	public void testselect() {
		User users = us.selectUser();
		System.out.println(users);
	}
	
	@Test
	public void testTelLogin() {
		boolean result = us.telLogin("13303028262");
		assertEquals(true, result);
	}
}
