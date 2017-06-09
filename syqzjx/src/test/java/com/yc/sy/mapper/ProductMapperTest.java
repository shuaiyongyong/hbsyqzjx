package com.yc.sy.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.sy.entity.Products;
import com.yc.sy.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ProductMapperTest {

	@Autowired
	private ProductMapper pm;
	
	@Test
	public void testGetPartProduct() {
		List<Products> ps = pm.getPartProduct(0, 12);
		System.out.println(ps);
	}
	@Test
	public void testGetPartProducts() {
		List<Products> ps = pm.getPartProducts(0, 12, 1);
		System.out.println(ps);
	}

}
