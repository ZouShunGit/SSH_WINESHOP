package com.studio.photo.dao;

import java.util.List;

import com.studio.photo.entity.Photo;

/**
 * ������Ƭ��dao�ӿ�
 * @author zoushun
 *
 */
public interface PhotoDao {
	//���
	public void add(Photo photo);
	//��ѯ
	public List<Photo> findAll(Photo photo);
	//�޸�
	public void update(Photo photo);
}
