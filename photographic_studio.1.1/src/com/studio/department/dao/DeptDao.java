package com.studio.department.dao;

import java.util.List;

import com.studio.department.entity.Department;

public interface DeptDao {
//��ѯ
	List<Department> findAll(Department dept);
	//���
	void add(Department dept);
	//�޸�
	void update(Department dept);

}
