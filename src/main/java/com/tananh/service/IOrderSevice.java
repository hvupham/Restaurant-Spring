package com.tananh.service;

import com.tananh.dto.OrderDto;
import com.tananh.modal.Order;

import java.util.List;

public interface IOrderSevice {
    Order createOrder(OrderDto orderDto) throws Exception;
    Order getOrder(Long id);
    Order updateOrder(Long id, OrderDto orderDTO) throws Exception;
    void deleteOrder(Long id);
    List<Order> findByUserId(Long userId);
}
