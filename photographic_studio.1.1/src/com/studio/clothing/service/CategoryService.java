package com.studio.clothing.service;

import java.util.List;

import com.studio.clothing.entity.Category;

public interface CategoryService {

	public List<Category> findAll(Category category);

	public void add(Category category);

	public void edit(Category category);

	public void delete(Category category);

}
