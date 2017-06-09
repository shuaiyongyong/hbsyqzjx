package com.yc.sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.sy.entity.PaginationBean;
import com.yc.sy.entity.ProductType;
import com.yc.sy.entity.Products;
import com.yc.sy.mapper.ProductMapper;
import com.yc.sy.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductType> typeList() {
		return productMapper.selectAllType();
	}

	@Override
	public List<Products> AllList() {
		return productMapper.selectAll();
	}


	@Override
	public List<Products> Select(int ptid) {
		return productMapper.selectProduct(ptid);
	}

	@Override
	public List<Products> SingleSelect(int pid) {
		return productMapper.selectPic(pid);
	}

	@Override
	public PaginationBean<Products> getPartProduct(String size, String page) {
		int currPage = 1;//默认当前页为第一页
		int pageSize = 12;//默认页面条数为12条
		if (size != null) {
			pageSize = Integer.parseInt(size);//取到"真实"的页面条数
		}
		int totalPage = getTotalPage(pageSize);
		if (page != null) {
			currPage = Integer.parseInt(page);
			if (currPage > totalPage) {//最后一页
				currPage = totalPage;
			} else if (currPage < 1) {//第一页
				currPage = 1;
			}
		}
		int start = (currPage-1)*pageSize;
				
		int end =pageSize;
		
		List<Products> products = productMapper.getPartProduct(start,end);
		return new PaginationBean<Products>(currPage, totalPage, products,pageSize * totalPage);
	}

	private int getTotalPage(int pageSize) {
		return productMapper.getTotalPage(  pageSize);
	}

	@Override
	public PaginationBean<Products> getPartProducts(String size, String page, int ptid) {
		int currPage = 1;//默认当前页为第一页
		int pageSize = 12;//默认页面条数为12条
		if (size != null) {
			pageSize = Integer.parseInt(size);//取到"真实"的页面条数
		}
		int totalPage = getTotalPages(pageSize,ptid);
		if (page != null) {
			currPage = Integer.parseInt(page);
			if(totalPage<1){
				totalPage = 1;
			}
			if (currPage > totalPage) {//最后一页
				currPage = totalPage;
			} else if (currPage < 1) {//第一页
				currPage = 1;
			}
		}
		int start = (currPage-1)*pageSize;
				
		int end =pageSize;
		System.out.println(currPage+"=========="+pageSize);
		System.out.println(start+"=========="+end);
		
		List<Products> products = productMapper.getPartProducts(start,end,ptid);
		return new PaginationBean<Products>(currPage, totalPage, products,pageSize * totalPage);
	}

	private int getTotalPages(int pageSize, int ptid) {
		return productMapper.getTotalPages(pageSize,ptid);
	}

	@Override
	public boolean SelectTypeByName(String ptname) {
		System.out.println("ly几号"+productMapper.SelectTypeByName(ptname));
		return productMapper.SelectTypeByName(ptname) != null ;
	}

	@Override
	public boolean AddProductType(ProductType pt) {
		return productMapper.AddProductType(pt) >0;
	}

	@Override
	public boolean ModifyProductType(ProductType pt) {
		return productMapper.ModifyProductType(pt) >0;
	}

	@Override
	public List<ProductType> selectTypeByPtid(int ptid) {
		return  productMapper.selectTypeByPtid(ptid);
	}

	@Override
	public boolean AddProduct(Products ps) {
		return productMapper.AddProduct(ps) >0;
	}

	@Override
	public boolean SelectProductByName(String pname) {
		System.out.println("productMapper.SelectProductByName(pname)"+productMapper.SelectProductByName(pname));
		return productMapper.SelectProductByName(pname).size()>0 ;
	}

	@Override
	public PaginationBean<ProductType> getPartProductType(String size, String page) {
		int currPage = 1;//默认当前页为第一页
		int pageSize = 12;//默认页面条数为12条
		if (size != null) {
			pageSize = Integer.parseInt(size);//取到"真实"的页面条数
		}
		int totalPage = getTotalPageType(pageSize);
		if (page != null) {
			currPage = Integer.parseInt(page);
			if (currPage > totalPage) {//最后一页
				currPage = totalPage;
			} else if (currPage < 1) {//第一页
				currPage = 1;
			}
		}
		int start = (currPage-1)*pageSize;
				
		int end =pageSize;
		
		List<ProductType> products = productMapper.getPartProductType(start,end);
		return new PaginationBean<ProductType>(currPage, totalPage, products,pageSize * totalPage);
	}

	private int getTotalPageType(int pageSize) {
		return productMapper.getTotalPageType(  pageSize);
	}

	@Override
	public boolean ModifyProduct(Products ps) {
		return productMapper.ModifyProduct(ps) >0;
	}



}
