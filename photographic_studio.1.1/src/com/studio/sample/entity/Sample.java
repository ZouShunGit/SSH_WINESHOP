package com.studio.sample.entity;

import java.util.Date;

import com.studio.util.PageBean;

/**
 * 样品的实体类类
 * 
 * @author zoushun
 *
 */
public class Sample {

	private int said;
	private String sname;
	private String img;
	private SampleCategory sampleCategory;
	private PageBean pageBean;
	private Date creattime;
	private int is_delete;
	public int getSaid() {
		return said;
	}
	public void setSaid(int said) {
		this.said = said;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public SampleCategory getSampleCategory() {
		return sampleCategory;
	}
	public void setSampleCategory(SampleCategory sampleCategory) {
		this.sampleCategory = sampleCategory;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
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
	@Override
	public String toString() {
		return "Sample [said=" + said + ", sname=" + sname + ", img=" + img + ", sampleCategory=" + sampleCategory
				+ ", pageBean=" + pageBean + ", creattime=" + creattime + ", is_delete=" + is_delete + "]";
	}

	
}
