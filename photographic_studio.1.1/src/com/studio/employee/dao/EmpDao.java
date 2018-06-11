package com.studio.employee.dao;

import java.util.List;

import com.studio.employee.entity.Employee;

public interface EmpDao {
	//查询
	public List<Employee> findAll(Employee emp);
	//添加
	public void add(Employee emp);
	//修改信息
	public void update(Employee emp);
	
	public List<Employee> find(Employee emp);

}
