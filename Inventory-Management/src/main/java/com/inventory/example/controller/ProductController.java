package com.inventory.example.controller;

import com.inventory.example.dto.ProductRequestDTO;
import com.inventory.example.service.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO productRequestDTO){
        return productService.addProduct(productRequestDTO);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllProductDetails(){
        return productService.getAllProductDetails();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long productId) {
        return productService.removeProduct(productId);
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<?> updateProductStatus(@PathVariable("id") Long productId, @PathVariable("status") String productStatus){
        return productService.updateProductStatus(productId, productStatus);
    }

    @GetMapping(value = "/stockDetails")
    public ResponseEntity<?> getProductStockDetails(){
        return productService.getProductStockDetails();
    }
}
