package com.studio.employeelevel.service;

import java.util.List;

import com.studio.employeelevel.entity.EmployeeLevel;

public interface EmpLevelService {

	public void edit(EmployeeLevel empl);

	public List<EmployeeLevel> findAll(EmployeeLevel empl);

	public void add(EmployeeLevel empl);

	public void delete(EmployeeLevel empl);

}
