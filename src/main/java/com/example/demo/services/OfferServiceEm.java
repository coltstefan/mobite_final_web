package com.example.demo.services;


import com.example.demo.domain.Offer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Primary
public class OfferServiceEm implements OfferService {

    @PersistenceContext
    private EntityManager em;



    @Override
    @Transactional
    public Offer save(Offer o) {
        em.merge(o);
        return o;
    }

    @Override
    public List<Offer> findAll() {

        TypedQuery<Offer> query = em.createQuery("SELECT o FROM Offer o",Offer.class);
        return query.getResultList();
    }


    @Override
    public Offer findOfferById(Long id) {

        TypedQuery<Offer> query = em.createQuery("select o from Offer o join fetch o.products where o.id = :id",Offer.class);
        query.setParameter("id",id);
        return query.getResultList().get(0);
    }

    @Override
    public Offer findOfferByRestaurant(Long id) {
        TypedQuery<Offer> query = em.createQuery("select o from Offer o where o.restaurant.id = :id",Offer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
