package com.studio.car.dao;

import java.util.List;

import com.studio.car.entity.Car;
/**
 * 购物车信息的Dao接口
 * @author zoushun
 *
 */
public interface CarDao {
	//查询
	public List<Car> findAll(Car car);
	//按条件删除
	public void delete(Car car);
	//添加
	public void add(Car car);
	//修改
	public void update(Car car);

}
