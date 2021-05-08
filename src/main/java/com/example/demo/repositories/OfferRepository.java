package com.example.demo.repositories;

import com.example.demo.domain.Offer;
import com.example.demo.domain.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer,Long> {

    @Query("select o from Offer o")
    List<Offer> findAll();

    @Query("select o from Offer o where o.id = :id")
    Offer findOfferById(Long id);

    @Query("select o from Offer o where o.restaurant.id = :id")
    Offer findOfferByRestaurant(Long id);

}
