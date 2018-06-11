package com.studio.clothing.dao;

import java.util.List;

import com.studio.clothing.entity.Clothing;

public interface ClothingDao {
	//��ѯ
	public List<Clothing> findAll(Clothing clothing);
	//���
	public void add(Clothing clothing);
	//�޸�
	public void update(Clothing clothing);

}
