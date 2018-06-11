package com.studio.car.service.impl;

import java.util.List;

import com.studio.car.dao.CarDao;
import com.studio.car.entity.Car;
import com.studio.car.service.CarService;

/**
 * ���ﳵ��service�ӿ�ʵ����
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
	 * ��ѯ���ﳵ��Ϣ
	 */
	@Override
	public List<Car> findAll(Car car) {
		// TODO Auto-generated method stub
		return carDao.findAll(car);
	}

	/**
	 * ɾ�����ﳵ�е�ĳ����Ϣ
	 */
	@Override
	public void delete(Car car) {
		// TODO Auto-generated method stub
		carDao.delete(car);
	}

	/**
	 * ��չ��ﳵ
	 */
	@Override
	public void clear(Car car) {
		// TODO Auto-generated method stub
		carDao.delete(car);
	}

	/**
	 * ��ӹ��ﳵ��Ϣ
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
