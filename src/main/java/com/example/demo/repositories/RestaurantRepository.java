package com.example.demo.repositories;

import com.example.demo.domain.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    @Query("SELECT r FROM Restaurant r")
    List<Restaurant> findAll();

    @Query("select r from Restaurant r where r.name = :name")
    Restaurant findRestaurantByName(String name);

    @Query("select r from Restaurant r where r.id = :id")
    Restaurant findRestaurantById(Long id);
}
