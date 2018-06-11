package com.studio.employeelevel.dao;

import java.util.List;

import com.studio.employeelevel.entity.EmployeeLevel;

public interface EmpLevelDao {

	public void add(EmployeeLevel empl);

	public void update(EmployeeLevel empl);

	public List<EmployeeLevel> findAll(EmployeeLevel empl);

}
