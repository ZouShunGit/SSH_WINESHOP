package com.studio.sample.dao;

import java.util.List;

import com.studio.sample.entity.Sample;

/**
 * 样品的dao接口
 * @author zoushun
 *
 */
public interface SampleDao {
	//修改
	public void update(Sample sample);
	//添加
	public void add(Sample sample);
	//查询
	public List<Sample> findAll(Sample sample);

}
