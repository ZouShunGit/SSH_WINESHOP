package com.studio.employee.dao;

import java.util.List;

import com.studio.employee.entity.Employee;

public interface EmpDao {
	//��ѯ
	public List<Employee> findAll(Employee emp);
	//���
	public void add(Employee emp);
	//�޸���Ϣ
	public void update(Employee emp);
	
	public List<Employee> find(Employee emp);

}
