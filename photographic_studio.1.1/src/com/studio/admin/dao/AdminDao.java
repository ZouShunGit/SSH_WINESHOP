package com.studio.admin.dao;

import java.util.List;

import com.studio.admin.entity.Admin;

public interface AdminDao {
	//登录
	public Admin login(Admin admin);
	//查询管理员记录
	public List<Admin> findAll(Admin admin);
	//添加
	public void add(Admin admin);
	//修改删除标记
	public void update(Admin admin);

}
