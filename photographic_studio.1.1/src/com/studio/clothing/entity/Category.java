package com.studio.clothing.entity;

import java.util.Date;
import java.util.HashSet;
/**
 * 服装一级分类实体类
 * @author zoushun
 *
 */
import java.util.Set;

import com.studio.util.PageBean;

public class Category {

	private int cid;
	private String cname;
	private String cdesc;
	private int is_delete;
	private Date creattime;
	private PageBean pageBean;
	/**
	 * 一个一级分类对应多个二及分类
	 */
	private Set<SecondCategory> secondCategories = new HashSet<>();
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}



	/**
	 * @return the secondCategories
	 */
	public Set<SecondCategory> getSecondCategories() {
		return secondCategories;
	}

	/**
	 * @param secondCategories the secondCategories to set
	 */
	public void setSecondCategories(Set<SecondCategory> secondCategories) {
		this.secondCategories = secondCategories;
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
		return "Category [cid=" + cid + ", cname=" + cname + ", cdesc=" + cdesc + ", is_delete=" + is_delete
				+ ", creattime=" + creattime + ", pageBean=" + pageBean + ", secondCategories=" + secondCategories
				+ "]";
	}

	
}
