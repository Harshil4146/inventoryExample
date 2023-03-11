package com.inventory.example.repository;

import com.inventory.example.entity.Product;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p.product_stock as ProductStock, p.product_name as ProductName, p.product_status as ProductStatus from tbl_product p", nativeQuery = true)
    List<ProductStockDetails> getProductStockDetails();

    interface ProductStockDetails{
        String  getProductName();
        Long getProductStock();
        String getProductStatus();
    }
}
