package com.studio.order.entity;

import java.util.Date;
import com.studio.user.entity.User;
import com.studio.util.PageBean;

/***
 * 订单实体类
 * 
 * @author zoushun
 *
 */
public class Order {

	private int oid;
	private String maleguests;// 男嘉宾
	private String femaleguests;// 女嘉宾
	private long otel;// 联系电话
	private String oaddress;// 联系地址
	private Date photodate;// 拍照时间
	private Date selectdate;// 选片时间
	private Double earnest;// 定金
	private Double realprice;// 应付
	private Integer ostate;// 1:未付款 2:未拍摄 3:已拍摄 4:完成

	private Date getdate;
	private Date creattime;
	private int is_delete;

	// private Admin admin;
	private User user;
	private String photographer;// 摄影师
	private String dresser;// 化妆师
	private PageBean pageBean;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getMaleguests() {
		return maleguests;
	}

	public void setMaleguests(String maleguests) {
		this.maleguests = maleguests;
	}

	public String getFemaleguests() {
		return femaleguests;
	}

	public void setFemaleguests(String femaleguests) {
		this.femaleguests = femaleguests;
	}

	public long getOtel() {
		return otel;
	}

	public void setOtel(long otel) {
		this.otel = otel;
	}

	public String getOaddress() {
		return oaddress;
	}

	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}

	public Date getPhotodate() {
		return photodate;
	}

	public void setPhotodate(Date photodate) {
		this.photodate = photodate;
	}

	public Date getSelectdate() {
		return selectdate;
	}

	public void setSelectdate(Date selectdate) {
		this.selectdate = selectdate;
	}

	public Double getEarnest() {
		return earnest;
	}

	public void setEarnest(Double earnest) {
		this.earnest = earnest;
	}

	public Double getRealprice() {
		return realprice;
	}

	public void setRealprice(Double realprice) {
		this.realprice = realprice;
	}

	public Integer getOstate() {
		return ostate;
	}

	public void setOstate(Integer ostate) {
		this.ostate = ostate;
	}

	public Date getGetdate() {
		return getdate;
	}

	public void setGetdate(Date getdate) {
		this.getdate = getdate;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	/**
	 * @return the is_delete
	 */
	public int getIs_delete() {
		return is_delete;
	}

	/**
	 * @param is_delete
	 *            the is_delete to set
	 */
	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	/**
	 * @return the photographer
	 */
	public String getPhotographer() {
		return photographer;
	}

	/**
	 * @param photographer
	 *            the photographer to set
	 */
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}

	/**
	 * @return the dresser
	 */
	public String getDresser() {
		return dresser;
	}

	/**
	 * @param dresser
	 *            the dresser to set
	 */
	public void setDresser(String dresser) {
		this.dresser = dresser;
	}

	/**
	 * @return the pageBean
	 */
	public PageBean getPageBean() {
		return pageBean;
	}

	/**
	 * @param pageBean
	 *            the pageBean to set
	 */
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", maleguests=" + maleguests + ", femaleguests=" + femaleguests + ", otel=" + otel
				+ ", oaddress=" + oaddress + ", photodate=" + photodate + ", selectdate=" + selectdate + ", earnest="
				+ earnest + ", realprice=" + realprice + ", ostate=" + ostate + ", getdate=" + getdate + ", creattime="
				+ creattime + ", is_delete=" + is_delete + ", user=" + user + ", photographer=" + photographer
				+ ", dresser=" + dresser + ", pageBean=" + pageBean + "]";
	}

}
