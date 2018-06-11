package com.studio.car.service;

import java.util.List;

import com.studio.car.entity.Car;
/**
 * ���ﳵ��service�ӿ�
 * @author zoushun
 *
 */
public interface CarService {

	public List<Car> findAll(Car car);

	public void delete(Car car);

	public void clear(Car car);

	public void add(Car car);

	public void edit(Car car);

}
