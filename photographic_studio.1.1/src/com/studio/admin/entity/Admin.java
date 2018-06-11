package com.studio.admin.entity;

import com.studio.util.PageBean;

public class Admin {
	private int aid;
	private String aname;
	private String aemail;
	private long atel;
	private int alevel;
	private String password;
	private int is_delete;
	private PageBean pageBean;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	public long getAtel() {
		return atel;
	}

	public void setAtel(long atel) {
		this.atel = atel;
	}

	public int getAlevel() {
		return alevel;
	}

	public void setAlevel(int alevel) {
		this.alevel = alevel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
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

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", aemail=" + aemail + ", atel=" + atel + ", alevel=" + alevel
				+ ", password=" + password + ", is_delete=" + is_delete + ", pageBean=" + pageBean + "]";
	}

}
