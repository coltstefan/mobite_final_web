package com.example.demo.services;

import com.example.demo.domain.Offer;
import com.example.demo.domain.Restaurant;

import java.util.List;

public interface OfferService {

    Offer save(Offer offer);
    List<Offer> findAll();
    Offer findOfferById(Long id);
    Offer findOfferByRestaurant(Long  id);


}
