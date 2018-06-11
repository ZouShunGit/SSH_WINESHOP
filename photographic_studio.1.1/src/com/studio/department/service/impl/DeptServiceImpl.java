package com.studio.department.service.impl;

import java.util.Date;
import java.util.List;

import com.studio.department.dao.DeptDao;
import com.studio.department.entity.Department;
import com.studio.department.service.deptService;

public class DeptServiceImpl implements deptService {
	private DeptDao deptDao;

	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public List<Department> findAll(Department dept) {
		// TODO Auto-generated method stub
		return deptDao.findAll(dept);
	}
	/**
	 * 部门添加
	 */
	@Override
	public void add(Department dept) {
		// TODO Auto-generated method stub
		dept.setDcreattime(new Date());
		deptDao.add(dept);
	}
	
	public void edit(Department dept) {
		deptDao.update(dept);
	}
	
	
	//部门删除
	@Override
	public void delete(Department dept) {
		// TODO Auto-generated method stub
		dept.setIs_delete(1);
		deptDao.update(dept);
	}
	
}
