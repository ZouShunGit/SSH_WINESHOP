package com.studio.clothing.dao;

import java.util.List;

import com.studio.clothing.entity.SecondCategory;

public interface SecondCategoryDao {
	//二级类别查询
	public List<SecondCategory> findAll(SecondCategory scategory);
	//添加二级分类
	public void add(SecondCategory scategory);
	//修改二级分类信息
	public void update(SecondCategory scategory);

}
