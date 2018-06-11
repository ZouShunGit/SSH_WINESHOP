package com.studio.clothing.service.impl;

import java.util.Date;
import java.util.List;

import com.studio.clothing.dao.CategoryDao;
import com.studio.clothing.entity.Category;
import com.studio.clothing.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryDao categoryDao;
	/**
	 * @return the categoryDao
	 */
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	/**
	 * @param categoryDao the categoryDao to set
	 */
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> findAll(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.findAll(category);
	}

	@Override
	public void add(Category category) {
		// TODO Auto-generated method stub
		category.setCreattime(new Date());
		categoryDao.add(category);
	}

	@Override
	public void edit(Category category) {
		// TODO Auto-generated method stub
		categoryDao.update(category);
	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub
		category.setIs_delete(1);
		categoryDao.update(category);
	}
}
