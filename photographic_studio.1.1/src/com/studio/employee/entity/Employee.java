package com.studio.employee.entity;

import java.util.Date;

import com.studio.department.entity.Department;
import com.studio.employeelevel.entity.EmployeeLevel;
import com.studio.util.PageBean;

/**
 * 员工实例
 * 
 * @author zoushun
 *
 */
public class Employee {
	private int eid;
	private String ename;
	private String esex;
	private long etel;
	private String eemail;
	private String edesc;
	private String eimg;
	private int is_delete;
	private Date ecreattime;
	private PageBean pageBean;

	// 每个员工都有一个部门
	private Department department;
	// 每个员工都有一个级别
	private EmployeeLevel employeeLevel;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsex() {
		return esex;
	}

	public void setEsex(String esex) {
		this.esex = esex;
	}

	public long getEtel() {
		return etel;
	}

	public void setEtel(long etel) {
		this.etel = etel;
	}

	public String getEemail() {
		return eemail;
	}

	public void setEemail(String eemail) {
		this.eemail = eemail;
	}

	public String getEdesc() {
		return edesc;
	}

	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}

	public String getEimg() {
		return eimg;
	}

	public void setEimg(String eimg) {
		this.eimg = eimg;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public Date getEcreattime() {
		return ecreattime;
	}

	public void setEcreattime(Date ecreattime) {
		this.ecreattime = ecreattime;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmployeeLevel getEmployeeLevel() {
		return employeeLevel;
	}

	public void setEmployeeLevel(EmployeeLevel employeeLevel) {
		this.employeeLevel = employeeLevel;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esex=" + esex + ", etel=" + etel + ", eemail=" + eemail
				+ ", edesc=" + edesc + ", eimg=" + eimg + ", is_delete=" + is_delete + ", ecreattime=" + ecreattime
				+ ", department=" + department + ", employeeLevel=" + employeeLevel + "]";
	}

	/**
	 * @return the pageBean
	 */
	public PageBean getPageBean() {
		return pageBean;
	}

	/**
	 * @param pageBean
	 *            the pageBean to set
	 */
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

}
