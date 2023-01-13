package com.example.springbootkafkaredis.controller;


import com.example.springbootkafkaredis.model.Product;
import com.example.springbootkafkaredis.model.ProductCategory;
import com.example.springbootkafkaredis.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@EnableCaching
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;


    @PostMapping("/api/categories")
    public ProductCategory addProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.addProductCategory(productCategory);
    }

    @GetMapping("/api/categories")
    public List<ProductCategory> getProductCategories() {
        return productCategoryService.findAll();
    }

    @GetMapping("/api/categories/{id}")
    public ProductCategory getCategoryById(@PathVariable int id) {
        return productCategoryService.getCategoryById(id);
    }


    @PutMapping("/api/categories")
    public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.updateProductCategory(productCategory);
    }

    @DeleteMapping("/api/categories/{id}")
    public String deleteProductCategory(@PathVariable int id) {
        return productCategoryService.deleteProductCategory(id);
    }

    @DeleteMapping("/api/categories/deleteAll")
    public String deleteAllCategory(){
        return productCategoryService.deleteAllCategory();
    }

}
