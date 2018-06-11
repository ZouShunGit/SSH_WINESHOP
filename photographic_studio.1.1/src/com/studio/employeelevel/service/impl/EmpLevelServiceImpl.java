package com.studio.employeelevel.service.impl;

import java.util.Date;
import java.util.List;

import com.studio.employeelevel.dao.EmpLevelDao;
import com.studio.employeelevel.entity.EmployeeLevel;
import com.studio.employeelevel.service.EmpLevelService;

public class EmpLevelServiceImpl implements EmpLevelService {
	private EmpLevelDao empLevelDao;

	public EmpLevelDao getEmpLevelDao() {
		return empLevelDao;
	}

	public void setEmpLevelDao(EmpLevelDao empLevelDao) {
		this.empLevelDao = empLevelDao;
	}
	@Override
	public List<EmployeeLevel> findAll(EmployeeLevel empl) {
		// TODO Auto-generated method stub
		return empLevelDao.findAll(empl);
	}
	/**
	 * 部门添加
	 */
	@Override
	public void add(EmployeeLevel empl) {
		// TODO Auto-generated method stub
		empl.setElcreattime(new Date());
		empLevelDao.add(empl);
	}
	
	public void edit(EmployeeLevel empl) {
		empLevelDao.update(empl);
	}
	
	
	//部门删除
	@Override
	public void delete(EmployeeLevel empl) {
		// TODO Auto-generated method stub
		empl.setIs_delete(1);
		empLevelDao.update(empl);
	}

}
	
