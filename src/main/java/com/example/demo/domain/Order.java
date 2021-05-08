package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"restaurant","client" , "products"})
@ToString(exclude = {"restaurant","client" , "products"})
@NoArgsConstructor
@Table(name = "Comenzi")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime time = LocalDateTime.of(LocalDate.now().getYear() , LocalDate.now().getMonth() , LocalDate.now().getDayOfMonth() , LocalDateTime.now().getHour() , LocalDateTime.now().getMinute());

    @ManyToOne
    private Restaurant restaurant;



    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name="comenzi_produse",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    private Set<Product> products = new HashSet<Product>();

    public void addProduct(Product p){
        products.add(p);
        p.getOrders().add(this);
    }



    private double total;




    public Order(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
