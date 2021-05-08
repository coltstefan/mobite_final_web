package com.example.demo.controllers;

import com.example.demo.domain.Offer;
import com.example.demo.services.OfferService;
import com.example.demo.services.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final RestaurantService restaurantService;


    public OfferController(OfferService offerService, RestaurantService restaurantService) {
        this.offerService = offerService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{id}")
    private String getOffers(@PathVariable(value = "id") Long id, Model model){

        model.addAttribute("offers" , offerService.findOfferByRestaurant(id));
        model.addAttribute("restaurant" , restaurantService.findRestaurantById(id));

        return "offers";

    }

    @GetMapping("/products/{id}")
    private String getOfferProducts(@PathVariable(value = "id") Long id,Model model){

        model.addAttribute("products" , offerService.findOfferById(id).getProducts());

        return "offer_products";


    }

    @GetMapping("/newOffer/{id}")
    private String newOffer(@PathVariable(value = "id")Long id ,Model model){

        Offer offer  = new Offer();
        model.addAttribute("offer",offer);
        model.addAttribute("products" , restaurantService.findRestaurantById(id).getProducts());
        return "new_offer";

    }

    @PostMapping("/saveOffer")
    public String saveOffer(@ModelAttribute("offer") Offer offer){
        offerService.save(offer);
        return "redirect:/restaurants";
    }

}
