package com.studio.car.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.car.entity.Car;

import com.studio.car.service.CarService;
import com.studio.set.service.SetService;
import com.studio.user.entity.User;
/**
 * 购物车的Action类
 * @author zoushun
 *
 */
public class CarAction extends ActionSupport implements ModelDriven<Car> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Car getModel() {
		// TODO Auto-generated method stub
		return car;
	}

	/**
	 * @return the carService
	 */
	public CarService getCarService() {
		return carService;
	}

	/**
	 * @param carService
	 *            the carService to set
	 */
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	/**
	 * @return the setService
	 */
	public SetService getSetService() {
		return setService;
	}

	/**
	 * @param setService
	 *            the setService to set
	 */
	public void setSetService(SetService setService) {
		this.setService = setService;
	}

	private Car car = new Car();
	private CarService carService;
	private SetService setService;

	/**
	 * 添加套餐信息到购物车
	 * 
	 * @return
	 */
	public String add() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if (user == null) {
			this.addActionMessage("您还未登录，请先登录！");
			return "msg";
		} else { 
			car.setId(user.getId());
			List<Car> cars = carService.findAll(car);
			//判断购物车中是否已有改套餐系列
			if (cars.isEmpty()) {
				car.setSetnum(1);
				car.setCarprice(car.getSet().getOnlineprice());
				carService.add(car);
			}else {
				Car c = new Car();
				for (Car ca : cars) {
					c = ca;
				}
				car.setCarid(c.getCarid());
				car.setSetnum(c.getSetnum()+1);
				car.setCarprice(car.getSet().getOnlineprice()*car.getSetnum());
				carService.edit(car);
			}
			return "find";
		}
	}

	/**
	 * 查询购物侧信息
	 * 
	 * @return
	 */
	public String findAll() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		car.setId(user.getId());
		List<Car> list = carService.findAll(car);
		if (list.isEmpty()) {
			this.addActionMessage("您还未添加套餐信息到购物车！");
			ServletActionContext.getRequest().getSession().removeAttribute("list");
		} else {
			Double total = 0.0;
			for (Car car : list) {
				total += car.getCarprice();
			}
			ServletActionContext.getRequest().getSession().setAttribute("list", list);
			ServletActionContext.getRequest().getSession().setAttribute("total", total);
		}
		return "findAll";
	}

	/**
	 * 通过carId删除购物车信息
	 * 
	 * @return
	 */
	public String delete() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		car.setId(user.getId());
		carService.delete(car);
		return "find";
	}

	/**
	 * 清空购物车信息
	 * 
	 * @return
	 */
	public String clear() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		car.setId(user.getId());
		carService.clear(car);
		return "find";

	}
}
