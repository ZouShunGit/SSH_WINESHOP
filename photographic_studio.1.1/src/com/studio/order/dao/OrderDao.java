package com.studio.order.dao;

import java.util.List;

import com.studio.order.entity.Order;

public interface OrderDao {
	//���
	public void add(Order order);
	//��ѯ
	public List<Order> findAll(Order order);
	//�޸�
	public void update(Order order);

}
