package com.example.demo.services;


import com.example.demo.domain.Product;
import com.example.demo.domain.Restaurant;

import java.util.List;

public interface ProductService {

    Product save(Product product);
    List<Product> findAll();
    List<Product>findAllByRestaurant(Long id);

}
