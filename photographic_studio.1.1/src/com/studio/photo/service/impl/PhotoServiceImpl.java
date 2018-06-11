package com.studio.photo.service.impl;

import java.util.List;

import com.studio.photo.dao.PhotoDao;
import com.studio.photo.entity.Photo;
import com.studio.photo.service.PhotoService;

/**
 * ������Ƭ��Service�ӿ�ʵ����
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
	 * ���ѡƬ
	 */
	@Override
	public void add(Photo photo) {
		// TODO Auto-generated method stub
		photoDao.add(photo);
	}

	/**
	 * ��ѯ������������Ϣ
	 */
	@Override
	public List<Photo> findAll(Photo photo) {
		// TODO Auto-generated method stub
		return photoDao.findAll(photo);
	}

	/**
	 * ����ѡƬ����Ϣ�޸�
	 */
	@Override
	public void delete(Photo photo) {
		// TODO Auto-generated method stub
		photo.setIs_delete(1);
		photoDao.update(photo);
	}

	/**
	 * �޸�ѡƬ��־
	 */
	@Override
	public void edit(Photo photo) {
		// TODO Auto-generated method stub
		photoDao.update(photo);
	}

}
