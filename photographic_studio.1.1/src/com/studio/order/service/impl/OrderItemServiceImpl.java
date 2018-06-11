package com.studio.order.service.impl;

import java.util.List;

import com.studio.order.dao.OrderItemDao;
import com.studio.order.entity.OrderItem;
import com.studio.order.service.OrderItemService;

/**
 * 
 * ���������service�ӿ�ʵ����
 * @author zoushun
 *
 */
public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemDao orderItemDao;

	/**
	 * @return the orderItemDao
	 */
	public OrderItemDao getOrderItemDao() {
		return orderItemDao;
	}

	/**
	 * @param orderItemDao the orderItemDao to set
	 */
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	@Override
	public void add(OrderItem item) {
		// TODO Auto-generated method stub
		orderItemDao.add(item);
	}

	@Override
	public List<OrderItem> findAll(OrderItem or) {
		// TODO Auto-generated method stub
		return orderItemDao.findAll(or);
	}
}
