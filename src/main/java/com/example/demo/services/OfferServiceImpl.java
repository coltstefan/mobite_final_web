package com.example.demo.services;

import com.example.demo.domain.Offer;
import com.example.demo.domain.Restaurant;
import com.example.demo.repositories.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    @Override
    public Offer findOfferById(Long id) {
        return offerRepository.findOfferById(id);
    }

    @Override
    public Offer findOfferByRestaurant(Long id) {
        return offerRepository.findOfferByRestaurant(id);
    }
}
