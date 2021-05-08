package com.example.demo.services;


import com.example.demo.domain.Order;
import com.example.demo.domain.Restaurant;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Primary
public class OrderServiceEm implements OrderService {

    @PersistenceContext
    private EntityManager em;



    @Override
    @Transactional
    public Order save(Order o) {
        em.persist(o);
        return o;
    }

    @Override
    public List<Order> findAll() {

        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o",Order.class);
        return query.getResultList();
    }

    @Override
    public List<Order> findOrderByRestaurant(Restaurant r) {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o where o.restaurant = :r",Order.class);
        query.setParameter("r" , r);
        return query.getResultList();
    }

    @Override
    public List<Order> findOrderById(Long id) {

        TypedQuery<Order> query = em.createQuery("select o from Order o join fetch o.products where o.id = :id",Order.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
}
