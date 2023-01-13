package com.example.springbootkafkaredis.service;


import com.example.springbootkafkaredis.model.Product;
import com.example.springbootkafkaredis.model.ProductCategory;
import com.example.springbootkafkaredis.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductService productService;


    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }


    public ProductCategory findCategoryById(int id) {
        return productCategoryRepository.findById(id).orElse(null);
    }

    public ProductCategory getCategoryById(int id) {
        return productCategoryRepository.findById(id).orElse(null);
    }

    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        ProductCategory existingProductCategory = productCategoryRepository.findById(productCategory.getcID()).orElse(null);
        existingProductCategory.setCategory_name(productCategory.getCategory_name());
        return productCategoryRepository.save(existingProductCategory);
    }

    public String deleteProductCategory(int id) {
        productCategoryRepository.deleteById(id);
        return "Deleted" + id;
    }

    public String deleteAllCategory(){
        productCategoryRepository.deleteAll();
        return "Deleted all Categories";
    }

    public ProductCategory addProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
