package com.studio.sample.service.impl;

import java.util.Date;
import java.util.List;

import com.studio.sample.dao.SampleDao;
import com.studio.sample.entity.Sample;
import com.studio.sample.service.SampleService;

/**
 * 样品的service接口的实现类
 * @author zoushun 
 *
 */
public class SampleServiceImpl implements SampleService {
	
	private SampleDao sampleDao;

	/**
	 * @return the sampleDao
	 */
	public SampleDao getSampleDao() {
		return sampleDao;
	}

	/**
	 * @param sampleDao the sampleDao to set
	 */
	public void setSampleDao(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}
 
	@Override
	public List<Sample> findAll(Sample sample) {
		// TODO Auto-generated method stub
		return sampleDao.findAll(sample);
	}

	@Override
	public void add(Sample sample) {
		// TODO Auto-generated method stub
		sample.setCreattime(new Date());
		sampleDao.add(sample);
	}

	@Override
	public void edit(Sample sample) {
		// TODO Auto-generated method stub
		sampleDao.update(sample);
	}

	@Override
	public void delete(Sample sample) {
		// TODO Auto-generated method stub
		sample.setIs_delete(1);
		System.out.println(sample);
		sampleDao.update(sample);
	}
	
}
