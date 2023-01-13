package com.example.springbootkafkaredis.service;


import com.example.springbootkafkaredis.model.Inventory;
import com.example.springbootkafkaredis.model.ManufacturingOrder;
import com.example.springbootkafkaredis.model.MaterialPurchaseOrder;
import com.example.springbootkafkaredis.repository.MaterialPurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialPurchaseOrderService {

    @Autowired
    private MaterialPurchaseOrderRepository materialPurchaseOrderRepository;


    public MaterialPurchaseOrder findMPOById(int id) {
        return materialPurchaseOrderRepository.findById(id).orElse(null);
    }

    public MaterialPurchaseOrder addMPO(MaterialPurchaseOrder materialPurchaseOrder) {
        return materialPurchaseOrderRepository.save(materialPurchaseOrder);
    }

    public List<MaterialPurchaseOrder> findAll() {
        return materialPurchaseOrderRepository.findAll();
    }

    public MaterialPurchaseOrder getMPOById(int id) {
        return materialPurchaseOrderRepository.findById(id).orElse(null);
    }
    public String deleteMPO(int id) {
        materialPurchaseOrderRepository.deleteById(id);
        return "Deleted " + id;
    }

    public String deleteAll() {
        materialPurchaseOrderRepository.deleteAll();
        return "All data is deleted";
    }

    public MaterialPurchaseOrder updateMPO(MaterialPurchaseOrder materialPurchaseOrder) {
        return materialPurchaseOrderRepository.save(materialPurchaseOrder);
    }
}
