package com.studio.employee.service.impl;

import java.util.Date;
import java.util.List;

import com.studio.employee.dao.EmpDao;
import com.studio.employee.entity.Employee;
import com.studio.employee.service.EmpService;

public class EmpServiceImpl implements EmpService {
	private EmpDao empDao;

	public EmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public List<Employee> findAll(Employee emp) {
		return empDao.findAll(emp);
	}

	@Override
	public void add(Employee emp) {
		// TODO Auto-generated method stub
		emp.setEcreattime(new Date());
		empDao.add(emp);
	}

	@Override
	public void edit(Employee emp) {
		// TODO Auto-generated method stub
		emp.setIs_delete(0);
		empDao.update(emp);
	}

	@Override
	public void delete(Employee emp) {
		// TODO Auto-generated method stub
		emp.setIs_delete(1);
		empDao.update(emp);
	}

	@Override
	public List<Employee> findEmp(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.find(emp);
	}
	
}
