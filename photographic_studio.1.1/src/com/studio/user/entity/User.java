package com.studio.user.entity;

import java.util.Date;

import com.studio.util.PageBean;

/**
 * 用户实体类
 * 
 * @author zoushun
 *
 */
public class User {
	private int id;
	private String uemail;
	private long utel;
	private String uname;
	private String usex;
	private int uage;
	private String uaddress;
	private String password;
	private String code;
	private Date ucreattime;//创建时间
	private PageBean pageBean;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public long getUtel() {
		return utel;
	}

	public void setUtel(long utel) {
		this.utel = utel;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getUcreattime() {
		return ucreattime;
	}

	public void setUcreattime(Date date) {
		this.ucreattime = date;
	}

	@Override
	public String toString() {
		return "User [uid=" + id + ", uemail=" + uemail + ", utel=" + utel + ", uname=" + uname + ", usex=" + usex
				+ ", uage=" + uage + ", uaddress=" + uaddress + ", password=" + password + ", code=" + code
				+ ", ucreattime=" + ucreattime + "]";
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
