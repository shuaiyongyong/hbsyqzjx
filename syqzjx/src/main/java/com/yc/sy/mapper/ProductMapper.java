package com.yc.sy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.sy.entity.ProductType;
import com.yc.sy.entity.Products;

public interface ProductMapper {

	List<ProductType> selectAllType();

	List<Products> selectAll();


	List<Products> selectProduct(int ptid);

	List<Products> selectPic(int pid);

	List<Products> getPartProduct(@Param("start") int start,@Param("end") int end);

	int getTotalPage(int pageSize);

	List<Products> getPartProducts(@Param("start") int start,@Param("end") int end, @Param("ptid") int ptid);


	int getTotalPages(@Param("pageSize") int pageSize, @Param("ptid") int ptid);

	ProductType SelectTypeByName(String ptname);

	int AddProductType(ProductType pt);

	int ModifyProductType(ProductType pt);

	List<ProductType> selectTypeByPtid(int ptid);

	int AddProduct(Products ps);

	List<Products> SelectProductByName(String pname);

	List<ProductType> getPartProductType(@Param("start")int start,@Param("end") int end);

	int getTotalPageType(int pageSize);

	int ModifyProduct(Products ps);


}