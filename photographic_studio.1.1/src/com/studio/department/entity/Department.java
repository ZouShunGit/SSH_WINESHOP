package com.studio.department.entity;

import java.util.Date;

import com.studio.util.PageBean;

/**
 * 部门实例
 * 
 * @author zoushun
 *
 */
public class Department {
	private int did;
	private String dname;
	private String ddesc;
	private int is_delete;// 0：正常；1：删除
	private Date dcreattime;
	private PageBean pageBean;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdesc() {
		return ddesc;
	}

	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public Date getDcreattime() {
		return dcreattime;
	}

	public void setDcreattime(Date dcreattime) {
		this.dcreattime = dcreattime;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", ddesc=" + ddesc + ", is_delete=" + is_delete
				+ ", dcreattime=" + dcreattime + "]";
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
