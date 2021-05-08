package com.example.demo.services;

import com.example.demo.domain.Restaurant;
import com.example.demo.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestaurantServiceImpl implements RestaurantService {



    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant save(Restaurant res) {

        return restaurantRepository.save(res);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findRestaurantByName(String name) {
        return restaurantRepository.findRestaurantByName(name);
    }

    @Override
    public Restaurant findRestaurantById(Long id) {
        return restaurantRepository.findRestaurantById(id);
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }
}
