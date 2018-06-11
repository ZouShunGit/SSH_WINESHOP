package com.studio.clothing.dao;

import java.util.List;

import com.studio.clothing.entity.Category;

public interface CategoryDao {
	//²éÑ¯
	public List<Category> findAll(Category category);
	//Ìí¼Ó
	public  void add(Category category);
	//ÐÞ¸Ä
	public void update(Category category);

}
