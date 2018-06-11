package com.studio.sample.service;

import java.util.List;

import com.studio.sample.entity.SampleCategory;

/**
 * ��Ʒ�����Service�ӿ�
 * @author zoushun
 *
 */
public interface SampleCategoryService {
	
	public List<SampleCategory> findAll(SampleCategory sampleCategory);

	public void add(SampleCategory sampleCategory);

	public void edit(SampleCategory sampleCategory);

	public void delete(SampleCategory sampleCategory);
	
}
