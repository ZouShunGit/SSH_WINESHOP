package com.studio.photo.service;

import java.util.List;

import com.studio.photo.entity.Photo;

/**
 * 在线相片的Service接口
 * @author zoushun
 *
 */
public interface PhotoService {
	//添加
	public void add(Photo photo);
	//查询所有
	public List<Photo> findAll(Photo photo);
	//删除信息
	public void delete(Photo photo);
	//选片标志修改
	public void edit(Photo photo);

}
