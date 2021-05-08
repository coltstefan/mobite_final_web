package com.example.demo.repositories;


import com.example.demo.domain.Product;
import com.example.demo.domain.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    @Query("select p from Product p")
    List<Product> findAll();

    @Query("select p from Product p where p.restaurant.id = :id")
    List<Product> findAllByRestaurant(Long  id);




}
