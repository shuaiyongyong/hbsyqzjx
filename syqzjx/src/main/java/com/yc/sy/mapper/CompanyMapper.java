package com.yc.sy.mapper;

import java.util.List;

import com.yc.sy.entity.Company;
import com.yc.sy.entity.Context;
import com.yc.sy.entity.Knows;
import com.yc.sy.entity.ProductType;

public interface CompanyMapper {

	Company selectCompInfo();

	List<ProductType> selectProductType();

	List<Knows> selectKnows();

	List<Context> selectContextByType(Context context);

	int updateCbrife(Company company);

	int updateCbrand(Company company);

	List<Context> selectContextByType1();
	List<Context> selectContextByType2();

	Context selectContextById(Context context);

	int updateCconcrete(Context context);

	int DelZ(Context context);

	int DelZ(int cid);

	int insertZzzs(Context context);

}
