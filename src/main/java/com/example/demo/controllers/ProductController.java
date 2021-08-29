package com.example.demo.controllers;


import com.example.demo.domain.Product;
import com.example.demo.domain.Restaurant;
import com.example.demo.services.ProductService;
import com.example.demo.services.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final RestaurantService restaurantService;

    public ProductController(ProductService productService , RestaurantService restaurantService) {
        this.productService = productService;
        this.restaurantService = restaurantService;
    }


    @GetMapping("/{id}")
    public String getProducts(@PathVariable Long id, Model model){
        model.addAttribute("restaurant" , restaurantService.findRestaurantById(id));
        model.addAttribute("products",productService.findAllByRestaurant(id));
        return "products";

    }

    @GetMapping("/newProduct/{id}")
    public String newProduct(@PathVariable Long id ,  Model model){

        Product product = new Product();
        model.addAttribute("product" , product);
        model.addAttribute("restaurant",restaurantService.findRestaurantById(id));
        return "new_product";

    }

    @PostMapping("/newProduct/saveProduct/{id}")
    public String saveProduct( @PathVariable Long id, @ModelAttribute("product") Product product){
        product.setRestaurant(restaurantService.findRestaurantById(id));
        productService.save(product);
       //System.out.println(restaurantService.findRestaurantById(id));
        return "redirect:/products/{id}";

    }

}
