package com.studio.clothing.dao;

import java.util.List;

import com.studio.clothing.entity.Category;

public interface CategoryDao {
	//��ѯ
	public List<Category> findAll(Category category);
	//���
	public  void add(Category category);
	//�޸�
	public void update(Category category);

}
