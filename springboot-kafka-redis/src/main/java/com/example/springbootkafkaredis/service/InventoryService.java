package com.example.springbootkafkaredis.service;


import com.example.springbootkafkaredis.model.Inventory;
import com.example.springbootkafkaredis.model.Product;
import com.example.springbootkafkaredis.model.ProductCategory;
import com.example.springbootkafkaredis.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory findInventoryById(int id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(int id) {
        return inventoryRepository.findById(id).orElse(null);
    }
    public String deleteInventory(int id) {
        inventoryRepository.deleteById(id);
        return "Deleted " + id;
    }

    public String deleteAll() {
        inventoryRepository.deleteAll();
        return "All data is deleted";
    }

    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}
