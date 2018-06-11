package com.studio.employeelevel.entity;

import java.util.Date;

import com.studio.util.PageBean;

/**
 * 员工级别实例
 * 
 * @author zoushun
 *
 */

public class EmployeeLevel {
	private int elid;
	private String elname;
	private String eldesc;
	private int is_delete;
	private Date elcreattime;
	private PageBean pageBean;
	public int getElid() {
		return elid;
	}

	public void setElid(int elid) {
		this.elid = elid;
	}

	public String getElname() {
		return elname;
	}

	public void setElname(String elname) {
		this.elname = elname;
	}

	public String getEldesc() {
		return eldesc;
	}

	public void setEldesc(String eldesc) {
		this.eldesc = eldesc;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public Date getElcreattime() {
		return elcreattime;
	}

	public void setElcreattime(Date elcreattime) {
		this.elcreattime = elcreattime;
	}

	@Override
	public String toString() {
		return "EmployeeLevel [elid=" + elid + ", elname=" + elname + ", eldesc=" + eldesc + ", is_delete=" + is_delete
				+ ", elcreattime=" + elcreattime + "]";
	}

	/**
	 * @return the pageBean
	 */
	public PageBean getPageBean() {
		return pageBean;
	}

	/**
	 * @param pageBean the pageBean to set
	 */
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

}
