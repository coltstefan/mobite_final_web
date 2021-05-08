package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"restaurant" , "orders"})
@ToString(exclude = {"restaurant" , "orders" , "offer"})
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private int stock;

    private double price;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private Offer offer;


    @ManyToMany(mappedBy = "products", cascade = CascadeType.DETACH )
    private Set<Order> orders = new HashSet<>();

    public Product(String name, String description, double price , int stock){
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }





}
