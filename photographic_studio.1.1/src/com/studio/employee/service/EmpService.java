package com.studio.employee.service;

import java.util.List;

import com.studio.employee.entity.Employee;

public interface EmpService {
	//��ѯԱ����Ϣ
	public List<Employee> findAll(Employee emp);
	//�����Ϣ
	public void add(Employee emp);
	//�޸���Ϣ
	public void edit(Employee emp);
	//ɾ����Ϣ
	public void delete(Employee emp);
	//��ѯԱ��
	public List<Employee> findEmp(Employee emp);

}
