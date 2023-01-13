package com.example.springbootkafkaredis.controller;


import com.example.springbootkafkaredis.model.Inventory;
import com.example.springbootkafkaredis.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@EnableCaching
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/api/inventories")
    public List<Inventory> getInventories() {
        return inventoryService.findAll();
    }

    @PutMapping("/api/inventories")
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        return inventoryService.updateInventory(inventory);
    }
}
