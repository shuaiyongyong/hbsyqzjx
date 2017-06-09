package com.yc.sy.service;

import java.util.List;

import com.yc.sy.entity.Company;
import com.yc.sy.entity.Context;
import com.yc.sy.entity.Knows;
import com.yc.sy.entity.ProductType;

public interface CompanyService {
	Company findComInfo();

	List<ProductType> findProductType();

	List<Knows> findKnows();

	List<Context> findContextByType(Context context);

	boolean changeComIntro(Company company);

	boolean changeLogo(Company company);
	
	List<Context> findContextByType1();
	List<Context> findContextByType2();

	Context findContextByCid(Context context1);

	boolean changeCconcrete(Context context);

	boolean delZzzs(int cid);

	boolean addZzzs(Context context);

}
