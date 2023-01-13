package com.example.springbootkafkaredis.repository;


import com.example.springbootkafkaredis.model.MaterialPurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialPurchaseOrderRepository extends JpaRepository<MaterialPurchaseOrder, Integer> {
}
