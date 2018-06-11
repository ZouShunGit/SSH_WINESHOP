package com.studio.car.entity;

import com.studio.set.entity.Set;

/**
 * 购物车的实体类
 * 
 * @author zoushun
 *
 */
public class Car {
	
	private int carid;
	private Double carprice;
	private int setnum;
	private int id;
 
	private Set set;

	public Car(int id, int carid) {
		// TODO Auto-generated constructor stub
		this.carid = carid;
		this.id = id;
	}

	public Car() {
		
	}
	public int getCarid() {
		return carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	public Double getCarprice() {
		return carprice;
	}

	public void setCarprice(Double carprice) {
		this.carprice = carprice;
	}

	public int getSetnum() {
		return setnum;
	}

	public void setSetnum(int setnum) {
		this.setnum = setnum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the set
	 */
	public Set getSet() {
		return set;
	}

	/**
	 * @param set
	 *            the set to set
	 */
	public void setSet(Set set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "Car [carid=" + carid + ", carprice=" + carprice + ", setnum=" + setnum + ", id=" + id + ", set=" + set
				+ "]";
	}
	
}
