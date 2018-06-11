package com.studio.department.dao;

import java.util.List;

import com.studio.department.entity.Department;

public interface DeptDao {
//²éÑ¯
	List<Department> findAll(Department dept);
	//Ìí¼Ó
	void add(Department dept);
	//ĞŞ¸Ä
	void update(Department dept);

}
