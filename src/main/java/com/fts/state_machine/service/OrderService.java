package com.fts.state_machine.service;

import com.fts.state_machine.model.Order;
import com.fts.state_machine.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

}
