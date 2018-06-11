package com.studio.clothing.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.studio.util.PageBean;

public class SecondCategory {
	/*
	 *  csid      NUMBER not null,
  name      VARCHAR2(50) not null,
  cid       NUMBER not null,
  scdesc    VARCHAR2(255),
  is_delete NUMBER not null,
  creattime DATE not null
	 */
	private int scid;
	private String name;
	private String scdesc;
	private int is_delete;
	private Date creattime;
	
	private PageBean pageBean;
	/**
	 * 每个二级分类都对应一个一级分类
	 */
	private Category category;
	/**
	 * 一个类别中有多件服装
	 */
	private Set<Clothing> clothings = new HashSet<>();
	
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScdesc() {
		return scdesc;
	}
	public void setScdesc(String scdesc) {
		this.scdesc = scdesc;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * @return the clothings
	 */
	public Set<Clothing> getClothings() {
		return clothings;
	}
	/**
	 * @param clothings the clothings to set
	 */
	public void setClothings(Set<Clothing> clothings) {
		this.clothings = clothings;
	}
	@Override
	public String toString() {
		return "SecondCategory [scid=" + scid + ", name=" + name + ", scdesc=" + scdesc + ", is_delete=" + is_delete
				+ ", creattime=" + creattime + ", category=" + category + "]";
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
