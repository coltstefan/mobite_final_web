package com.example.demo.services;

import com.example.demo.domain.Order;
import com.example.demo.domain.Restaurant;
import com.example.demo.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findOrderByRestaurant(Restaurant r) {
        return orderRepository.findOrderByRestaurant(r);
    }


    @Override
    public List<Order> findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }
}
