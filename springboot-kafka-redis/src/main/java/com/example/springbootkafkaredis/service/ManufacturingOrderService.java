package com.example.springbootkafkaredis.service;


import com.example.springbootkafkaredis.model.ManufacturingOrder;
import com.example.springbootkafkaredis.model.MaterialPurchaseOrder;
import com.example.springbootkafkaredis.model.ProductLine;
import com.example.springbootkafkaredis.repository.ManufacturingOrderRepository;
import com.example.springbootkafkaredis.repository.ProductLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ManufacturingOrderService {
    @Autowired
    private ManufacturingOrderRepository manufacturingOrderRepository;
    @Autowired
    private ProductLineRepository productLineRepository;

    @Autowired
    private ProductLineService productLineService;

    @Autowired
    private MaterialPurchaseOrderService materialPurchaseOrderService;

    public ManufacturingOrder findMOById(int id) {
        return manufacturingOrderRepository.findById(id).orElse(null);
    }
    public ManufacturingOrder addMO(ManufacturingOrder manufacturingOrder) {
        ManufacturingOrder manufacturingOrder1 = new ManufacturingOrder();
        manufacturingOrder1.setStatus(manufacturingOrder.getStatus());
        manufacturingOrder1.setDateOfMO(manufacturingOrder.getDateOfMO());
        manufacturingOrder1.setClient_name(manufacturingOrder.getClient_name());
        manufacturingOrder1.setDateOfDL(manufacturingOrder.getDateOfDL());
        manufacturingOrder1.setDateOfSt(manufacturingOrder.getDateOfDL());
        manufacturingOrder1.setDateOfEC(manufacturingOrder.getDateOfEC());
        manufacturingOrder1.getProductLines().addAll(manufacturingOrder.getProductLines()
                .stream().map(productLine -> {
                    if (productLine.getPlID() > 0) {
                        ProductLine productLine1 = productLineRepository.findById(productLine.getPlID()).orElse(null);
                        productLine1.getMo().add(manufacturingOrder1);
                        return productLine1;
                    }
                    else {
                        ProductLine productLine2 = productLineRepository.findById(productLineService.addProductLine(productLine).getPlID()).orElse(null);
                        productLine2.getMo().add(manufacturingOrder1);
                        return productLine2;
                    }
                }).collect(Collectors.toSet()));
        MaterialPurchaseOrder materialPurchaseOrder = new MaterialPurchaseOrder();
        materialPurchaseOrder.setMoID(manufacturingOrderRepository.save(manufacturingOrder1).getMoID());
        materialPurchaseOrderService.addMPO(materialPurchaseOrder);
        return manufacturingOrder;
    }

    public List<ManufacturingOrder> findAll() {
        return manufacturingOrderRepository.findAll();
    }


    public ManufacturingOrder getMOById(int id) {
        return manufacturingOrderRepository.findById(id).orElse(null);
    }

    public String deleteAll() {
        manufacturingOrderRepository.deleteAll();
        return "All data is deleted";
    }

    public ManufacturingOrder updateMO(ManufacturingOrder manufacturingOrder) {
        ManufacturingOrder manufacturingOrder1 = manufacturingOrderRepository.findById(manufacturingOrder.getMoID()).orElse(null);
        manufacturingOrder1.setStatus(manufacturingOrder.getStatus());
        manufacturingOrder1.setDateOfMO(manufacturingOrder.getDateOfMO());
        manufacturingOrder1.setClient_name(manufacturingOrder.getClient_name());
        manufacturingOrder1.setDateOfDL(manufacturingOrder.getDateOfDL());
        manufacturingOrder1.setDateOfSt(manufacturingOrder.getDateOfDL());
        manufacturingOrder1.setDateOfEC(manufacturingOrder.getDateOfEC());
        manufacturingOrder1.getProductLines().addAll(manufacturingOrder.getProductLines()
                .stream().map(productLine -> {
                    if (productLine.getPlID() > 0) {
                        ProductLine productLine1 = productLineRepository.findById(productLine.getPlID()).orElse(null);
                        productLine1.getMo().add(manufacturingOrder1);
                        return productLine1;
                    }
                    else {
                        ProductLine productLine2 = productLineRepository.findById(productLineService.addProductLine(productLine).getPlID()).orElse(null);
                        productLine2.getMo().add(manufacturingOrder1);
                        return productLine2;
                    }
                }).collect(Collectors.toSet()));
        return manufacturingOrderRepository.save(manufacturingOrder1);
    }

    public String deleteMoById(int id) {
        manufacturingOrderRepository.deleteById(id);
        return "deleted mo " + id;
    }

    public ManufacturingOrder SetOK(int id) {
        ManufacturingOrder manufacturingOrder = manufacturingOrderRepository.findById(id).orElse(null);
        manufacturingOrder.setStatus("OK");
        return manufacturingOrderRepository.save(manufacturingOrder);
    }
}
