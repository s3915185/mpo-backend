package com.example.springbootkafkaredis.controller;


import com.example.springbootkafkaredis.model.Product;
import com.example.springbootkafkaredis.model.ProductCategory;
import com.example.springbootkafkaredis.service.InventoryService;
import com.example.springbootkafkaredis.service.ProductService;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@EnableCaching
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private InventoryService inventoryService;


    @PostMapping("/api/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/api/products/{id}")
    @Cacheable(key = "#id", value = "Product")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }


    @PutMapping("/api/products")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/api/products/{id}")
    public String deleteProduct(@PathVariable int id) {
        inventoryService.deleteInventory(id);
        return productService.deleteProduct(id);
    }


    @DeleteMapping("/api/products/deleteAll")
    public String deleteAllProduct() {
        return productService.deleteAll();
    }
}
