package com.studio.clothing.dao;

import java.util.List;

import com.studio.clothing.entity.Clothing;

public interface ClothingDao {
	//²éÑ¯
	public List<Clothing> findAll(Clothing clothing);
	//Ìí¼Ó
	public void add(Clothing clothing);
	//ÐÞ¸Ä
	public void update(Clothing clothing);

}
