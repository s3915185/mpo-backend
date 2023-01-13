package com.example.springbootkafkaredis.service;


import com.example.springbootkafkaredis.model.Inventory;
import com.example.springbootkafkaredis.model.Product;
import com.example.springbootkafkaredis.model.ProductCategory;
import com.example.springbootkafkaredis.repository.ProductCategoryRepository;
import com.example.springbootkafkaredis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private InventoryService inventoryService;

    public Product findProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        Inventory inventory = new Inventory();
        inventory.setpID(productRepository.save(product).getpID());
        inventory.setQuantity(0);
        inventoryService.addInventory(inventory);
        return product;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }


    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getpID()).orElse(null);
        existingProduct.setProduct_name(product.getProduct_name());
        existingProduct.setProduct_code(product.getProduct_code());
        existingProduct.setProduct_description(product.getProduct_description());
        existingProduct.setCategory(product.getCategory());
        return productRepository.save(existingProduct);
    }


    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Deleted " + id;
    }

    public String deleteAll() {
        productRepository.deleteAll();
        return "All data is deleted";
    }
}
