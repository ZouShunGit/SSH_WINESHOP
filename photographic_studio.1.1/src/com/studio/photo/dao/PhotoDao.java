package com.studio.photo.dao;

import java.util.List;

import com.studio.photo.entity.Photo;

/**
 * 在线相片的dao接口
 * @author zoushun
 *
 */
public interface PhotoDao {
	//添加
	public void add(Photo photo);
	//查询
	public List<Photo> findAll(Photo photo);
	//修改
	public void update(Photo photo);
}
