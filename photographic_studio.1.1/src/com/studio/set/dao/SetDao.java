package com.studio.set.dao;

import java.util.List;

import com.studio.set.entity.Set;

public interface SetDao {
	//查询
	public List<Set> findAll(Set set);
	//添加
	public void add(Set set);
	//修改信息
	public void update(Set set);
}
