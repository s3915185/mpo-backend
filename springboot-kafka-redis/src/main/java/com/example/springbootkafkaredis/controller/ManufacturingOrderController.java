package com.example.springbootkafkaredis.controller;

import com.example.springbootkafkaredis.model.ManufacturingOrder;
import com.example.springbootkafkaredis.service.ManufacturingOrderService;
import com.example.springbootkafkaredis.service.MaterialPurchaseOrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
//@EnableCaching
@CrossOrigin(origins = "http://localhost:3000")
public class ManufacturingOrderController {
    @Autowired
    private ManufacturingOrderService manufacturingOrderService;
    @Autowired
    private MaterialPurchaseOrderService materialPurchaseOrderService;

    @PostMapping("/api/mo")
    public ResponseEntity<?> addMO(@RequestBody ManufacturingOrder manufacturingOrder) {
        return new ResponseEntity<>(manufacturingOrderService.addMO(manufacturingOrder), HttpStatus.CREATED);
    }

    @GetMapping("/api/mo")
    public List<ManufacturingOrder> getMOs() {
        return manufacturingOrderService.findAll();
    }

    @GetMapping("/api/mo/{id}")
    public ManufacturingOrder getMOById(@PathVariable int id) {
        return manufacturingOrderService.getMOById(id);
    }

    @PutMapping("/api/mo")
    public ManufacturingOrder updateMO(@RequestBody ManufacturingOrder manufacturingOrder) {
        return manufacturingOrderService.updateMO(manufacturingOrder);
    }

    @DeleteMapping("/api/mo/{moID}")
    public String deleteMoById(@PathVariable int moID) {
        materialPurchaseOrderService.deleteMPO(moID);
        return manufacturingOrderService.deleteMoById(moID);
    }
}
