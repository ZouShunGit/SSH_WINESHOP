package com.studio.order.service;

import java.util.List;

import com.studio.order.entity.Order;

/**
 * ������Ϣ��Service�ӿ�
 * @author zoushun
 *
 */
public interface OrderService {

	public void add(Order order);

	public List<Order> findAll(Order order);

	public void edit(Order order);

	public void delete(Order order);

}
