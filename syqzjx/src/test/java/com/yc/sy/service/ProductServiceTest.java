package com.yc.sy.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.sy.entity.PaginationBean;
import com.yc.sy.entity.ProductType;
import com.yc.sy.entity.Products;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ProductServiceTest {

	@Autowired
	private ProductService ps;
	
	@Test
	public void testTypeList() {
		List<ProductType> pt = ps.typeList();
		System.out.println(pt);
		assertNotNull(pt);
	}
	
	
	@Test
	public void testList() {
		PaginationBean<Products> pts = ps.getPartProduct("12", "1");
		System.out.println(pts);
	}
	@Test
	public void testLists() {
		PaginationBean<Products> pts = ps.getPartProducts("12", "1",5);
		System.out.println(pts);
	}
	
	@Test
	public void testTypeLists() {
		PaginationBean<ProductType> ptb = ps.getPartProductType("10", "0");
		System.out.println(ptb);
	}

	@Test
	public void testSelect() {
		List<Products> pts = ps.Select(2);
		System.out.println(pts);
		assertNotNull(pts);
	}

	@Test
	public void testSingleSelect() {
		List<Products> pts = ps.SingleSelect(1);
		System.out.println(pts);
		assertNotNull(pts);
	}
	
	@Test
	public void testSelectTypeByName(){
		boolean result = ps.SelectTypeByName("");
		System.out.println(result);
	}
	
	@Test
	public void testAddType(){
		ProductType pt = new ProductType();
		pt.setPtname("小昆机02");
		boolean result = ps.AddProductType(pt);
		System.out.println(result);
	}
	
	@Test
	public void testModifyType(){
		ProductType pt = new ProductType();
		pt.setPtname("小昆机01");
		pt.setPtid(28);
		boolean result = ps.ModifyProductType(pt);
		System.out.println(result);
	}
	
	@Test
	public void testAddProduct(){
		Products p = new Products();
		p.setPbrife("asfasfsag");
		p.setPname("aaaa");
		p.setPpic("asfafa");
		p.setPtid(1);
		boolean result = ps.AddProduct(p);
		System.out.println(result);
	}
	
	@Test
	public void testSelectProductByName(){
		boolean result = ps.SelectProductByName("");
		System.out.println(result);
	}
	
	@Test
	public void testModify(){
		Products pt = new Products();
		pt.setPname("小鸡");
		pt.setPbrife("好鸡");
		pt.setPpic("upload\\1.jpg");
		pt.setPid(8);
		pt.setPtid(5);
		boolean result = ps.ModifyProduct(pt);
		System.out.println(result);
	}
}
