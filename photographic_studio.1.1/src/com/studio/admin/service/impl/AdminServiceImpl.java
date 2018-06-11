package com.studio.admin.service.impl;

import java.util.List;

import com.studio.admin.dao.AdminDao;
import com.studio.admin.entity.Admin;
import com.studio.admin.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	/**
	 * ��¼
	 */
	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.login(admin);
	}
	/**
	 * ��ѯ���еĹ���Ա
	 */
	@Override
	public List<Admin> findAll(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.findAll(admin);
	}
	
	/**
	 * ��ӹ���Ա
	 */
	@Override
	public void add(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.add(admin);
	}

	@Override
	public void delete(Admin admin) {
		// TODO Auto-generated method stub
		admin.setIs_delete(1);
		adminDao.update(admin);
	}

	@Override
	public void editPass(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.update(admin);
	}

	@Override
	public void edit(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.update(admin);
	}
	
	
	
}
