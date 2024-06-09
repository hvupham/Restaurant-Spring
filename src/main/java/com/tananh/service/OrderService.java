package com.tananh.service;

import com.tananh.dto.OrderDto;
import com.tananh.modal.Order;
import com.tananh.modal.User;
import com.tananh.respository.OrderRepository;
import com.tananh.respository.UserResponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderService implements  IOrderSevice{
    private final UserResponsitory userResponsitory;
    private final OrderRepository orderRepository;


    @Override
    @Transactional
    public Order createOrder(OrderDto orderDto) throws Exception {
        User user = userResponsitory
                .findById(orderDto.getUser().getId())
                .orElseThrow(() -> new Exception("Cannot find user with id: "+ orderDto.getUser().getId()));

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(new Date());



        orderRepository.save(order);
        return order;
    }

    @Override
    public Order getOrder(Long id) {
        return null;
    }

    @Override
    public Order updateOrder(Long id, OrderDto orderDTO) throws Exception {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return null;
    }
}
