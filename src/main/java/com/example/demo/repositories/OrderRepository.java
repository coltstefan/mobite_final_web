package com.example.demo.repositories;


import com.example.demo.domain.Order;
import com.example.demo.domain.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("select o from Order o")
    List<Order> findAll();

    @Query("select o from Order o where o.id = :id")
    List<Order> findOrderById(Long id);

    @Query("select o from Order o where o.restaurant = :restaurant")
    List<Order> findOrderByRestaurant(Restaurant restaurant);










}
