package com.studio.order.dao;

import java.util.List;

import com.studio.order.entity.Order;

public interface OrderDao {
	//Ìí¼Ó
	public void add(Order order);
	//²éÑ¯
	public List<Order> findAll(Order order);
	//ĞŞ¸Ä
	public void update(Order order);

}
