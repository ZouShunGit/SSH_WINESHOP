package com.studio.clothing.service.impl;

import java.util.Date;
import java.util.List;

import com.studio.clothing.dao.ClothingDao;
import com.studio.clothing.entity.Clothing;
import com.studio.clothing.service.ClothingService;

/**
 * 服装信息Service实现类
 * 
 * @author zoushun
 *
 */
public class ClothingServiceImpl implements ClothingService {
	private ClothingDao clothingDao;

	/**
	 * @return the clothingDao
	 */
	public ClothingDao getClothingDao() {
		return clothingDao;
	}

	/**
	 * @param clothingDao
	 *            the clothingDao to set
	 */
	public void setClothingDao(ClothingDao clothingDao) {
		this.clothingDao = clothingDao;
	}

	/**
	 * 查询服装信息
	 */
	@Override
	public List<Clothing> findAll(Clothing clothing) {
		// TODO Auto-generated method stub
		return clothingDao.findAll(clothing);
	}

	/**
	 * 添加服装信息
	 */
	@Override
	public void add(Clothing clothing) {
		// TODO Auto-generated method stub
		clothing.setCreattime(new Date());
		clothingDao.add(clothing);
	}

	/**
	 * 。
	 * 修改服装信息
	 */
	@Override
	public void edit(Clothing clothing) {
		// TODO Auto-generated method stub
		clothingDao.update(clothing);
	}

	/**
	 * 删除服装信息
	 */
	@Override
	public void delete(Clothing clothing) {
		// TODO Auto-generated method stub
		clothing.setIs_delete(1);
		clothingDao.update(clothing);
	}
}
