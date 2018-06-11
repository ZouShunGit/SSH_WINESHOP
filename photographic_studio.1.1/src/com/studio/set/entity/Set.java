package com.studio.set.entity;
/***
 * 套餐系列的实体类
 * @author zoushun
 *
 */

import java.util.Date;

import com.studio.util.PageBean;

public class Set {

	private int setid;
	private String setname;
	private String setimg;
	private int clothingnum;
	private int imgnum;
	private String setdesc;
	private Double facdeprice;
	private Double onlineprice;
	private int is_delete;
	private Date creattime;
	private PageBean pageBean = new PageBean();

	public int getSetid() {
		return setid;
	}

	public void setSetid(int setid) {
		this.setid = setid;
	}

	public String getSetname() {
		return setname;
	}

	public void setSetname(String setname) {
		this.setname = setname;
	}

	public String getSetimg() {
		return setimg;
	}

	public void setSetimg(String setimg) {
		this.setimg = setimg;
	}

	public int getClothingnum() {
		return clothingnum;
	}

	public void setClothingnum(int clothingnum) {
		this.clothingnum = clothingnum;
	}

	public int getImgnum() {
		return imgnum;
	}

	public void setImgnum(int imgnum) {
		this.imgnum = imgnum;
	}

	public String getSetdesc() {
		return setdesc;
	}

	public void setSetdesc(String setdesc) {
		this.setdesc = setdesc;
	}

	public Double getFacdeprice() {
		return facdeprice;
	}

	public void setFacdeprice(Double facdeprice) {
		this.facdeprice = facdeprice;
	}

	public Double getOnlineprice() {
		return onlineprice;
	}

	public void setOnlineprice(Double onlineprice) {
		this.onlineprice = onlineprice;
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
		return "Set [setid=" + setid + ", setname=" + setname + ", setimg=" + setimg + ", clothingnum=" + clothingnum
				+ ", imgnum=" + imgnum + ", setdesc=" + setdesc + ", facdeprice=" + facdeprice + ", onlineprice="
				+ onlineprice + ", is_delete=" + is_delete + ", creattime=" + creattime + ", pageBean=" + pageBean
				+ "]";
	}

}
