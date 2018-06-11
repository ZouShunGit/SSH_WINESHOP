package com.studio.car.dao;

import java.util.List;

import com.studio.car.entity.Car;
/**
 * ���ﳵ��Ϣ��Dao�ӿ�
 * @author zoushun
 *
 */
public interface CarDao {
	//��ѯ
	public List<Car> findAll(Car car);
	//������ɾ��
	public void delete(Car car);
	//���
	public void add(Car car);
	//�޸�
	public void update(Car car);

}
