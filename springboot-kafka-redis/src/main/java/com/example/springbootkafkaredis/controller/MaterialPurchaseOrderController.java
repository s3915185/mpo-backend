package com.example.springbootkafkaredis.controller;


import com.example.springbootkafkaredis.model.ManufacturingOrder;
import com.example.springbootkafkaredis.model.MaterialPurchaseOrder;
import com.example.springbootkafkaredis.service.ManufacturingOrderService;
import com.example.springbootkafkaredis.service.MaterialPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@EnableCaching
@CrossOrigin(origins = "http://localhost:3000")
public class MaterialPurchaseOrderController {

    @Autowired
    private MaterialPurchaseOrderService materialPurchaseOrderService;
    @Autowired
    private ManufacturingOrderService manufacturingOrderService;

    @GetMapping("/api/mpo")
    public List<MaterialPurchaseOrder> getMPOs() {
        return materialPurchaseOrderService.findAll();
    }

    @PutMapping("/api/mpo/{id}")
    public ManufacturingOrder updateMPO(@PathVariable int id) {
        return manufacturingOrderService.SetOK(id);
    }

    @DeleteMapping("/api/mpo/{id}")
    public String deleteMPO(@PathVariable int id) {
        manufacturingOrderService.deleteMoById(id);
        return materialPurchaseOrderService.deleteMPO(id);
    }
}
