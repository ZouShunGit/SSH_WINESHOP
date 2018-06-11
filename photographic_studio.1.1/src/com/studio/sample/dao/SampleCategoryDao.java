package com.studio.sample.dao;

import java.util.List;

import com.studio.sample.entity.SampleCategory;

/**
 * 样品级别的Dao接口
 * @author zoushun
 *
 */
public interface SampleCategoryDao {
	//查询
	public List<SampleCategory> findAll(SampleCategory sampleCategory);
	//添加
	public void add(SampleCategory sampleCategory);
	//修改
	public void update(SampleCategory sampleCategory);

}
