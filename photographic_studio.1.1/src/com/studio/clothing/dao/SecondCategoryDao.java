package com.studio.clothing.dao;

import java.util.List;

import com.studio.clothing.entity.SecondCategory;

public interface SecondCategoryDao {
	//��������ѯ
	public List<SecondCategory> findAll(SecondCategory scategory);
	//��Ӷ�������
	public void add(SecondCategory scategory);
	//�޸Ķ���������Ϣ
	public void update(SecondCategory scategory);

}
