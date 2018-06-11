package com.studio.clothing.service;

import java.util.List;

import com.studio.clothing.entity.SecondCategory;

public interface SecondCategoryService {
	//查询二级类别信息
	public List<SecondCategory> findAll(SecondCategory scategory);
	//添加二级分类信息
	public void add(SecondCategory scategory);
	//编辑二级分类信息
	public void edit(SecondCategory scategory);
	//删除二级分类信息
	public void delete(SecondCategory scategory);

}
