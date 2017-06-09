package com.yc.sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.sy.entity.Company;
import com.yc.sy.entity.Context;
import com.yc.sy.entity.Knows;
import com.yc.sy.entity.ProductType;
import com.yc.sy.mapper.CompanyMapper;
import com.yc.sy.service.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public Company findComInfo() {
		return companyMapper.selectCompInfo();
	}

	@Override
	public List<ProductType> findProductType() {
		return companyMapper.selectProductType();
	}

	@Override
	public List<Knows> findKnows() {
		return companyMapper.selectKnows();
	}

	@Override
	public List<Context> findContextByType(Context context) {
		return companyMapper.selectContextByType(context);
	}

	@Override
	public boolean changeComIntro(Company company) {
		return companyMapper.updateCbrife(company)>0;
	}

	@Override
	public boolean changeLogo(Company company) {
		return companyMapper.updateCbrand(company)>0;
	}

	@Override
	public List<Context> findContextByType1() {
		return companyMapper.selectContextByType1();
	}
	@Override
	public List<Context> findContextByType2() {
		return companyMapper.selectContextByType2();
	}

	@Override
	public Context findContextByCid(Context context) {
		return companyMapper.selectContextById(context);
	}

	@Override
	public boolean changeCconcrete(Context context) {
		return companyMapper.updateCconcrete(context)>0;
	}

	@Override
	public boolean delZzzs(int cid) {
		return companyMapper.DelZ(cid)>0;
	}

	@Override
	public boolean addZzzs(Context context) {
		return companyMapper.insertZzzs(context)>0;
	}

	

}
