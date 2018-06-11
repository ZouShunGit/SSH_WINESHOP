package com.studio.photo.entity;

import java.util.Date;

import com.studio.util.PageBean;

/**
 * 在线相片的实体类
 * 
 * @author zoushun
 *
 */
public class Photo {
	private int pid;
	private int oid;
	private String pimg;
	private Date photodate;
	private int sign;
	private int is_delete;
	private PageBean pageBean;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Date getPhotodate() {
		return photodate;
	}

	public void setPhotodate(Date photodate) {
		this.photodate = photodate;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	/**
	 * @return the pimg
	 */
	public String getPimg() {
		return pimg;
	}

	/**
	 * @param pimg the pimg to set
	 */
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	@Override
	public String toString() {
		return "Photo [pid=" + pid + ", oid=" + oid + ", pimg=" + pimg + ", photodate=" + photodate + ", sign=" + sign
				+ ", is_delete=" + is_delete + "]";
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
