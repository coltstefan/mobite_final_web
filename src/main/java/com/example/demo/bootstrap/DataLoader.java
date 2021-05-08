package com.example.demo.bootstrap;


import com.example.demo.domain.Offer;
import com.example.demo.domain.Order;
import com.example.demo.domain.Product;
import com.example.demo.domain.Restaurant;

import com.example.demo.services.OfferService;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import com.example.demo.services.RestaurantService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final RestaurantService restaurantService;
    private final ProductService productService;
    private final OrderService orderService;
    private final OfferService offerService;


    public DataLoader(RestaurantService restaurantService, ProductService productService, @Qualifier("orderServiceEm") OrderService orderService, @Qualifier("offerServiceEm") OfferService offerService) {
        this.restaurantService = restaurantService;

        this.productService = productService;
        this.orderService = orderService;
        this.offerService = offerService;
    }


    @Override
    public void run(String... args) throws Exception {

        Restaurant r1 = new Restaurant("Pizza Hut");
        Restaurant r2 = new Restaurant("Dominos");
        Restaurant r3 = new Restaurant("McDonalds");
        Restaurant r4 = new Restaurant("KFC");

        Product p1 = new Product("Pizza Capriciosa","description" , 29.99 , 10);
        Product p2 = new Product("Pizza Diavola","description" , 19.99 , 32);

        Product p3 = new Product("Pizza Chicken Club","description" , 35.99 , 12);
        Product p4 = new Product("Pizza Pepperoni","description" , 29.99 , 54);

        Product p5 = new Product("Big Mac","description" , 16.99 , 32);
        Product p6 = new Product("Chicken Nuggets","description" , 12.99 , 12);

        Product p7 = new Product("Double Hot Booster","description" , 10.99 , 12);
        Product p8 = new Product("Crispy Strips","description" , 23.99 , 32);
//
//        Client c1 = new Client("Stefan");
//        Client c2 = new Client("Marius");
//
        Order o1 = new Order();
        Order o2 = new Order();
        Order o3 = new Order();

        Offer offer1 = new Offer("Pizza Hut");
        Offer offer2 = new Offer("Dominos");
        Offer offer3 = new Offer("KFC");

        offer1.addProduct(p1);
       // offer1.addProduct(p2);

        offer2.addProduct(p3);
        offer2.addProduct(p4);

        offer3.addProduct(p7);
        offer3.addProduct(p8);

//
        o1.addProduct(p1);
        o1.addProduct(p2);
//
        o2.addProduct(p1);

        o3.addProduct(p3);
        o3.addProduct(p4);



//
//
//        c1.addOrder(o1);
//        c2.addOrder(o2);
//        c1.addOrder(o3);
//
//
//
//
//
        r1.addProduct(p1);
        r1.addProduct(p2);
        r2.addProduct(p3);
        r2.addProduct(p4);
        r3.addProduct(p5);
        r3.addProduct(p6);
        r4.addProduct(p7);
        r4.addProduct(p8);
//
//        r1.addClient(c1);
//        r1.addClient(c2);
//
        r1.addOrder(o1);
        r1.addOrder(o2);
        r2.addOrder(o3);

        r1.setOffer(offer1);
        offer1.setRestaurant(r1);
        r2.setOffer(offer2);
        offer2.setRestaurant(r2);
        r4.setOffer(offer3);
        offer3.setRestaurant(r4);








        restaurantService.save(r1);
        restaurantService.save(r2);
        restaurantService.save(r3);
        restaurantService.save(r4);

        productService.save(p1);
        productService.save(p2);
        productService.save(p3);
        productService.save(p4);
        productService.save(p5);
        productService.save(p6);
        productService.save(p7);
        productService.save(p8);
//
//        clientService.save(c1);
//        clientService.save(c2);
//
        orderService.save(o1);
        orderService.save(o2);
        orderService.save(o3);

//        offerService.save(offer1);
//        offerService.save(offer2);
//        offerService.save(offer3);







        //System.out.println(restaurantService.findAll());

        System.out.println(orderService.findOrderById(16L).get(0).getProducts());
        System.out.println(orderService.findOrderById(17L).get(0).getProducts());
        System.out.println(orderService.findOrderById(18L).get(0).getProducts());

        System.out.println(offerService.findOfferById(2L).getProducts());
        System.out.println(offerService.findAll());
        System.out.println(offerService.findOfferByRestaurant(1L));



        // System.out.println(orderService.findOrderByClient(c1).get(0).getProducts());

//        System.out.println(orderService.findOrderByRestaurant(r1));
//        System.out.println(orderService.findOrderByClient(c1).get(0).getProducts().toString());
        /*System.out.println(restaurantService.findRestaurantById(1L));
        System.out.println(restaurantService.findAll().get(0).getId());

        System.out.println(productService.findAll());
        System.out.println(productService.findAllByRestaurant(r1.getId()));
        System.out.println(productService.findAllByRestaurant(r2.getId()));
        System.out.println(clientService.findAll());
        System.out.println(clientService.findByRestaurant(r1));*/

    }
}
