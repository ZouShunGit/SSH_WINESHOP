package com.studio.employee.service;

import java.util.List;

import com.studio.employee.entity.Employee;

public interface EmpService {
	//查询员工信息
	public List<Employee> findAll(Employee emp);
	//添加信息
	public void add(Employee emp);
	//修改信息
	public void edit(Employee emp);
	//删除信息
	public void delete(Employee emp);
	//查询员工
	public List<Employee> findEmp(Employee emp);

}
