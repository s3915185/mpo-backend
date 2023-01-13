package com.example.springbootkafkaredis.controller;


import com.example.springbootkafkaredis.model.ProductLine;
import com.example.springbootkafkaredis.service.ProductLineService;
import com.example.springbootkafkaredis.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@EnableCaching
@Transactional
@CrossOrigin(origins = "http://localhost:3000")
public class ProductLineController {

    @Autowired
    private ProductLineService productLineService;


    @GetMapping("/api/productlines")
    public List<ProductLine> findAll() {
        return productLineService.findAll();
    }


    @PostMapping("/api/productlines")
    public ProductLine addProductLine(@RequestBody ProductLine productLine) {
        return productLineService.addProductLine(productLine);
    }
}
