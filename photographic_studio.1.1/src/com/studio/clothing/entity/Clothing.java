package com.studio.clothing.entity;
/**
 * 衣服的实体类
 * @author zoushun
 *
 */

import java.util.Date;

import com.studio.util.PageBean;

public class Clothing {
	/*
	 * cid NUMBER not null, cimg VARCHAR2(225) not null, cdesc VARCHAR2(225),
	 * is_delete NUMBER default 0 not null, csid NUMBER not null, creattsime DATE
	 */
	private int cid;
	private String cimg;
	private String cdesc;
	private int is_delete;
	private Date creattime;
	
	private PageBean pageBean;
	
	/**
	 * 一件对应一个二级分类
	 */
	private SecondCategory secondCategory;
	
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCimg() {
		return cimg;
	}

	public void setCimg(String cimg) {
		this.cimg = cimg;
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

	public SecondCategory getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(SecondCategory secondCategory) {
		this.secondCategory = secondCategory;
	}

	@Override
	public String toString() {
		return "Clothing [cid=" + cid + ", cimg=" + cimg + ", cdesc=" + cdesc + ", is_delete=" + is_delete
				+ ", creattime=" + creattime + ", secondCategory=" + secondCategory + "]";
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
