package com.example.demo.services;



import com.example.demo.domain.Order;
import com.example.demo.domain.Restaurant;

import java.util.List;

public interface OrderService {

    Order save(Order order);
    List<Order> findAll();
    List<Order> findOrderByRestaurant(Restaurant r);
    List<Order> findOrderById(Long id);


}
