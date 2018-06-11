package com.studio.order.dao;

import java.util.List;

import com.studio.order.entity.OrderItem;

/**
 * 订单详情的Dao接口
 * @author zoushun
 *
 */
public interface OrderItemDao {

	public void add(OrderItem item);

	public List<OrderItem> findAll(OrderItem or);

}
