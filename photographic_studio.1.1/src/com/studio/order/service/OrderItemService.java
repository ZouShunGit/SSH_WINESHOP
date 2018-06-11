package com.studio.order.service;

import java.util.List;

import com.studio.order.entity.OrderItem;

/**
 * 订单详情的service接口
 * @author zoushun
 *
 */
public interface OrderItemService {

	public void add(OrderItem item);

	public List<OrderItem> findAll(OrderItem or);

}
