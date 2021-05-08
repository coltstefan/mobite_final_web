package com.example.demo.services;

import com.example.demo.domain.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RestaurantService {

    Restaurant save(Restaurant res);
    List<Restaurant> findAll();
    Restaurant findRestaurantByName(String name);
    Restaurant findRestaurantById(Long id);
    void deleteRestaurantById(Long id);


}
