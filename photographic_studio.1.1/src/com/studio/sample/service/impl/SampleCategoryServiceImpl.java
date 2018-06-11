package com.studio.sample.service.impl;

import java.util.Date;
import java.util.List;

import com.studio.sample.dao.SampleCategoryDao;
import com.studio.sample.entity.SampleCategory;
import com.studio.sample.service.SampleCategoryService;

/**
 * 样品级别的service接口的实现类
 * @author zoushun
 *
 */
public class SampleCategoryServiceImpl implements SampleCategoryService {
	
	private SampleCategoryDao sampleCategoryDao;

	/**
	 * @return the sampleCategoryDao
	 */
	public SampleCategoryDao getSampleCategoryDao() {
		return sampleCategoryDao;
	}

	/**
	 * @param sampleCategoryDao the sampleCategoryDao to set
	 */
	public void setSampleCategoryDao(SampleCategoryDao sampleCategoryDao) {
		this.sampleCategoryDao = sampleCategoryDao;
	}

	@Override
	public List<SampleCategory> findAll(SampleCategory sampleCategory) {
		// TODO Auto-generated method stub
		return sampleCategoryDao.findAll(sampleCategory);
	}

	@Override
	public void add(SampleCategory sampleCategory) {
		// TODO Auto-generated method stub
		sampleCategory.setSccreattime(new Date());
		sampleCategoryDao.add(sampleCategory);
	}

	@Override
	public void edit(SampleCategory sampleCategory) {
		// TODO Auto-generated method stub
		sampleCategoryDao.update(sampleCategory);
	}

	@Override
	public void delete(SampleCategory sampleCategory) {
		// TODO Auto-generated method stub
		sampleCategory.setScis_delete(1);
		sampleCategoryDao.update(sampleCategory);
	}
}
