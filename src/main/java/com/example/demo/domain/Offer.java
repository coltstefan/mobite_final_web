package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"restaurant","client" , "products"})
@ToString(exclude = {"restaurant","client" , "products"})
@NoArgsConstructor
public class Offer {


    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    private Restaurant restaurant;


    @OneToMany(mappedBy = "offer" , cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public Offer(String name){
        this.name = name;
    }

    public void addProduct(Product p){
        products.add(p);
        p.setOffer(this);
    }

}
