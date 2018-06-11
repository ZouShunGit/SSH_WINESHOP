package com.studio.order.entity;

import com.studio.set.entity.Set;

/**
 * 订单项实体类
 * 
 * @author zoushun
 *
 */
public class OrderItem {
	/*
	 * oiid NUMBER not null, setnum NUMBER not null, setid NUMBER not null
	 */

	private int oiid;
	private int setnum;
	private Set set;
	private int oid;

	public int getOiid() {
		return oiid;
	}

	public void setOiid(int oiid) {
		this.oiid = oiid;
	}

	public int getSetnum() {
		return setnum;
	}

	public void setSetnum(int setnum) {
		this.setnum = setnum;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	@Override
	public String toString() {
		return "OrderItem [oiid=" + oiid + ", setnum=" + setnum + ", set=" + set + ", oid=" + oid + "]";
	}
}
