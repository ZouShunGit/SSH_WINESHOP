package com.studio.order.service.impl;

import java.util.List;

import com.studio.order.dao.OrderDao;
import com.studio.order.entity.Order;
import com.studio.order.service.OrderService;

/**
 * ������Ϣ��Service�ӿ�ʵ����
 * 
 * @author zoushun
 *
 */
public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;

	/**
	 * @return the orderDao
	 */
	public OrderDao getOrderDao() {
		return orderDao;
	}

	/**
	 * @param orderDao
	 *            the orderDao to set
	 */
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	/***
	 * ���ɶ���
	 */
	@Override
	public void add(Order order) {
		// TODO Auto-generated method stub
		orderDao.add(order);
	}
	/**
	 * ��ѯ������Ϣ
	 */
	@Override
	public List<Order> findAll(Order order) {
		// TODO Auto-generated method stub
		return orderDao.findAll(order);
	}
/**
 * �޸Ķ���
 */
	@Override
	public void edit(Order order) {
		// TODO Auto-generated method stub
		orderDao.update(order);
	}
/**
 * ɾ������
 */
	@Override
	public void delete(Order order) {
		// TODO Auto-generated method stub
		order.setIs_delete(1);
		orderDao.update(order);
	}
}
