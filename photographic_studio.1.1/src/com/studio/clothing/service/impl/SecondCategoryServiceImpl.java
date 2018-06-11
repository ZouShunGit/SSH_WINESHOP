package com.studio.clothing.service.impl;

import java.util.Date;
import java.util.List;

import com.studio.clothing.dao.SecondCategoryDao;
import com.studio.clothing.entity.SecondCategory;
import com.studio.clothing.service.SecondCategoryService;

public class SecondCategoryServiceImpl implements SecondCategoryService {
	
	private SecondCategoryDao scategoryDao;

	/**
	 * @return the scategoryDao
	 */
	public SecondCategoryDao getScategoryDao() {
		return scategoryDao;
	}

	/**
	 * @param scategoryDao the scategoryDao to set
	 */
	public void setScategoryDao(SecondCategoryDao scategoryDao) {
		this.scategoryDao = scategoryDao;
	}

	@Override
	public List<SecondCategory> findAll(SecondCategory scategory) {
		// TODO Auto-generated method stub
		return scategoryDao.findAll(scategory);
	}

	@Override
	public void add(SecondCategory scategory) {
		// TODO Auto-generated method stub
		scategory.setCreattime(new Date());
		scategoryDao.add(scategory);
	}
	
	@Override
	public void edit(SecondCategory scategory) {
		// TODO Auto-generated method stub
		scategory.setIs_delete(0);
		scategoryDao.update(scategory);
	}

	@Override
	public void delete(SecondCategory scategory) {
		// TODO Auto-generated method stub
		scategory.setIs_delete(1);
		scategoryDao.update(scategory);
	}
}
