package com.studio.set.dao;

import java.util.List;

import com.studio.set.entity.Set;

public interface SetDao {
	//��ѯ
	public List<Set> findAll(Set set);
	//���
	public void add(Set set);
	//�޸���Ϣ
	public void update(Set set);
}
