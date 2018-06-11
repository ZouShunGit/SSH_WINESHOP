package com.studio.photo.service.impl;

import java.util.List;

import com.studio.photo.dao.PhotoDao;
import com.studio.photo.entity.Photo;
import com.studio.photo.service.PhotoService;

/**
 * 在线相片的Service接口实现类
 * 
 * @author zoushun
 *
 */
public class PhotoServiceImpl implements PhotoService {

	private PhotoDao photoDao;

	/**
	 * @return the photoDao
	 */
	public PhotoDao getPhotoDao() {
		return photoDao;
	}

	/**
	 * @param photoDao
	 *            the photoDao to set
	 */
	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}

	/**
	 * 添加选片
	 */
	@Override
	public void add(Photo photo) {
		// TODO Auto-generated method stub
		photoDao.add(photo);
	}

	/**
	 * 查询符合条件的信息
	 */
	@Override
	public List<Photo> findAll(Photo photo) {
		// TODO Auto-generated method stub
		return photoDao.findAll(photo);
	}

	/**
	 * 在线选片库信息修改
	 */
	@Override
	public void delete(Photo photo) {
		// TODO Auto-generated method stub
		photo.setIs_delete(1);
		photoDao.update(photo);
	}

	/**
	 * 修改选片标志
	 */
	@Override
	public void edit(Photo photo) {
		// TODO Auto-generated method stub
		photoDao.update(photo);
	}

}
