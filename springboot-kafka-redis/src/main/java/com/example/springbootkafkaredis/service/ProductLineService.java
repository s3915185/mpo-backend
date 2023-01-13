package com.example.springbootkafkaredis.service;


import com.example.springbootkafkaredis.model.ProductLine;
import com.example.springbootkafkaredis.repository.ProductLineRepository;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLineService {

    @Autowired
    private ProductLineRepository productLineRepository;



    public List<ProductLine> findAll() {
        return productLineRepository.findAll();
    }

    public ProductLine addProductLine(ProductLine productLine) {
        return productLineRepository.save(productLine);
    }

    public String deteleteProductLineById(int id) {
        productLineRepository.deleteById(id);
        return "Deleted Product Line " + id;
    }
}
