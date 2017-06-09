package com.yc.sy.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.sy.entity.Knows;
import com.yc.sy.entity.PaginationBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class KnowServiceTest {

	@Autowired
	private KnowService ks;
	
	@Test
	public void testSelectAllKnows() {
		PaginationBean<Knows> k = ks.getPartKnow("12", "0");
		System.out.println(k);
		assertNotNull(k);;
	}
	
	@Test
	public void testSelectSingleKnows() {
		List<Knows> k = ks.singleKnows(1);
		System.out.println(k);
		assertNotNull(k);;
	}
	
	@Test
	public void testAddKnows() {
		Knows k = new Knows();
		k.setKtag("傻逼");
		k.setKcontent("哈哈哈哈哈!!!");
		boolean result = ks.addKnows(k);
		System.out.println(result);
		assertNotNull(result);;
	}
	
	@Test
	public void testRemoveKnows() {
		boolean result = ks.removeKnows(30);
		System.out.println(result);
		assertNotNull(result);;
	}
}
