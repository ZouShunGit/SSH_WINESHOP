package com.studio.department.service;

import java.util.List;

import com.studio.department.entity.Department;

public interface deptService {
	//��ѯ������Ϣ
	public List<Department> findAll(Department dept);
	//��Ӳ���
	void add(Department dept);
	//ɾ������
	public void delete(Department dept);
	//�����޸�
	public void edit(Department dept);

}
