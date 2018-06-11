package com.studio.photo.service;

import java.util.List;

import com.studio.photo.entity.Photo;

/**
 * ������Ƭ��Service�ӿ�
 * @author zoushun
 *
 */
public interface PhotoService {
	//���
	public void add(Photo photo);
	//��ѯ����
	public List<Photo> findAll(Photo photo);
	//ɾ����Ϣ
	public void delete(Photo photo);
	//ѡƬ��־�޸�
	public void edit(Photo photo);

}
