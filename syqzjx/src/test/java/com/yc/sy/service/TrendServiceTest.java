package com.yc.sy.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.sy.entity.PaginationBean;
import com.yc.sy.entity.Trends;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TrendServiceTest {

	@Autowired
	private TrendService ts;
	
	@Test
	public void testTrendList() {
		List<Trends> t = ts.trendList();
		System.out.println(t);
		assertNotNull(t);
	}
	@Test
	public void testList() {
		PaginationBean<Trends> t = ts.getPartTrend("12", "1");
		System.out.println(t);
		assertNotNull(t);
	}
	
	@Test
	public void testTrendNews() {
		List<Trends> t = ts.singleNews(1);
		System.out.println(t);
		assertNotNull(t);
	}

}
