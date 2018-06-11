package com.studio.department.service;

import java.util.List;

import com.studio.department.entity.Department;

public interface deptService {
	//查询部门信息
	public List<Department> findAll(Department dept);
	//添加部门
	void add(Department dept);
	//删除部门
	public void delete(Department dept);
	//部门修改
	public void edit(Department dept);

}
