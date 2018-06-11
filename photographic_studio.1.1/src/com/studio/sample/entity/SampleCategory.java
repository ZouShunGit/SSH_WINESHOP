package com.studio.sample.entity;

import java.util.Date;

import com.studio.util.PageBean;

/**
 * 样品级别的实体类
 * @author zoushun
 *
 */
public class SampleCategory {
	private int scid;
	private String scname;
	private String scdesc;
	private int scis_delete;
	private Date sccreattime;
	
	private PageBean pageBean;
	
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
	public String getScdesc() {
		return scdesc;
	}
	public void setScdesc(String scdesc) {
		this.scdesc = scdesc;
	}
	public int getScis_delete() {
		return scis_delete;
	}
	public void setScis_delete(int scis_delete) {
		this.scis_delete = scis_delete;
	}
	public Date getSccreattime() {
		return sccreattime;
	}
	public void setSccreattime(Date sccreattime) {
		this.sccreattime = sccreattime;
	}
	@Override
	public String toString() {
		return "SampleCategory [scid=" + scid + ", scname=" + scname + ", scdesc=" + scdesc + ", scis_delete="
				+ scis_delete + ", sccreattime=" + sccreattime + ", pageBean=" + pageBean + "]";
	}
}
