
package com.productmangment.productmangment.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    // Get all products
    @GetMapping("/products")
    public String getProducts() {
        return "All products are here";
    }

    // Create a product
    @PostMapping("/products")
    public String createProduct() {
        return "New product created";
    }

    // Get one product by ID
    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable Long id) {
        return "Product ID: " + id;
    }

    // Update a product
    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id) {
        return "Product " + id + " updated";
    }

    // Delete a product
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return "Product " + id + " deleted";
    }
}
