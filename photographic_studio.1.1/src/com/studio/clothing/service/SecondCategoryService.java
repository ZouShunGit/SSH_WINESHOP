package com.studio.clothing.service;

import java.util.List;

import com.studio.clothing.entity.SecondCategory;

public interface SecondCategoryService {
	//��ѯ���������Ϣ
	public List<SecondCategory> findAll(SecondCategory scategory);
	//��Ӷ���������Ϣ
	public void add(SecondCategory scategory);
	//�༭����������Ϣ
	public void edit(SecondCategory scategory);
	//ɾ������������Ϣ
	public void delete(SecondCategory scategory);

}
