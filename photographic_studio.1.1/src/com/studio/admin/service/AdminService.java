package com.studio.admin.service;

import java.util.List;
/**
 * 管理员的Service接口
 */
import com.studio.admin.entity.Admin;

public interface AdminService {
	//管理员登录
	public Admin login(Admin admin);
	//管理员查询
	public List<Admin> findAll(Admin admin);
	//添加管理员
	public void add(Admin admin);
	//管理员删除
	public void delete(Admin admin);
	//密码修改
	public void editPass(Admin admin);
	//管理员信息修改
	public void edit(Admin admin);

}
