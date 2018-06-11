package com.studio.clothing.service;

import java.util.List;

import com.studio.clothing.entity.Clothing;

public interface ClothingService {
	//查询服装信息
	public List<Clothing> findAll(Clothing clothing);
	//添加服装信息
	public void add(Clothing clothing);
	//修改服装信息
	public void edit(Clothing clothing);
	//删除服装信息
	public void delete(Clothing clothing);

}
