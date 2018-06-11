package com.studio.set.entity;

import java.util.Date;

import com.studio.user.entity.User;
import com.studio.util.PageBean;

public class Comments {
	private int comid;
	private String comdesc;
	private Date creattime;
	private int is_delete;
	private User user;
	private Set set;
	private PageBean pageBean;

	public int getComid() {
		return comid;
	}

	public void setComid(int comid) {
		this.comid = comid;
	}

	public String getComdesc() {
		return comdesc;
	}

	public void setComdesc(String comdesc) {
		this.comdesc = comdesc;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	/**
	 * @return the set
	 */
	public Set getSet() {
		return set;
	}

	/**
	 * @param set the set to set
	 */
	public void setSet(Set set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "Comments [comid=" + comid + ", comdesc=" + comdesc + ", creattime=" + creattime + ", is_delete="
				+ is_delete + ", user=" + user + ", set=" + set + ", pageBean=" + pageBean + "]";
	}
}
