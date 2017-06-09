package com.yc.sy.service;

import java.util.List;

import com.yc.sy.entity.Products;
import com.yc.sy.entity.PaginationBean;
import com.yc.sy.entity.ProductType;

public interface ProductService {

	List<ProductType> typeList();

	List<Products> AllList();

	List<Products> Select(int ptid);

	List<Products> SingleSelect(int pid);
	

	PaginationBean<Products> getPartProduct(String pageSize, String currPage);

	PaginationBean<Products> getPartProducts(String pageSize, String currPage, int ptid);

	boolean SelectTypeByName(String ptname);

	boolean AddProductType(ProductType pt);

	boolean ModifyProductType(ProductType pt);

	List<ProductType> selectTypeByPtid(int ptid);

	boolean AddProduct(Products ps);

	boolean SelectProductByName(String pname);

	PaginationBean<ProductType> getPartProductType(String pageSize, String currPage);

	boolean ModifyProduct(Products ps);


}
