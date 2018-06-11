package com.studio.car.service.impl;

import java.util.List;

import com.studio.car.dao.CarDao;
import com.studio.car.entity.Car;
import com.studio.car.service.CarService;

/**
 * 购物车的service接口实现类
 * 
 * @author zoushun
 *
 */
public class CarServiceImpl implements CarService {

	private CarDao carDao;

	/**
	 * @return the carDao
	 */
	public CarDao getCarDao() {
		return carDao;
	}

	/**
	 * @param carDao
	 *            the carDao to set
	 */
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	/**
	 * 查询购物车信息
	 */
	@Override
	public List<Car> findAll(Car car) {
		// TODO Auto-generated method stub
		return carDao.findAll(car);
	}

	/**
	 * 删除购物车中的某条信息
	 */
	@Override
	public void delete(Car car) {
		// TODO Auto-generated method stub
		carDao.delete(car);
	}

	/**
	 * 清空购物车
	 */
	@Override
	public void clear(Car car) {
		// TODO Auto-generated method stub
		carDao.delete(car);
	}

	/**
	 * 添加购物车信息
	 */
	@Override
	public void add(Car car) {
		// TODO Auto-generated method stub
		carDao.add(car);
	}

	@Override
	public void edit(Car car) {
		// TODO Auto-generated method stub
		carDao.update(car);
	}

}
