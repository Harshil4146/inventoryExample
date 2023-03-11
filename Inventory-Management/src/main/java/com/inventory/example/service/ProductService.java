package com.inventory.example.service;

import com.inventory.example.dto.ProductRequestDTO;
import com.inventory.example.dto.ProductResponseDTO;
import com.inventory.example.entity.Product;
import com.inventory.example.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public ResponseEntity<?> addProduct(ProductRequestDTO productRequestDTO) {
        Product product = modelMapper.map(productRequestDTO, Product.class);
        ProductResponseDTO response = modelMapper.map(productRepository.save(product), ProductResponseDTO.class);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("message", "Product added successfully");
        resultMap.put("product_details", response);
        return ResponseEntity.ok().body(resultMap);
    }

    public ResponseEntity<?> getAllProductDetails() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDTO> products = productList.stream()
                .map(product -> modelMapper.map(product, ProductResponseDTO.class))
                .collect(Collectors.toList());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("message", "All products details fetch successfully");
        resultMap.put("product_details", products);
        return ResponseEntity.ok().body(resultMap);
    }

    @Transactional
    public ResponseEntity<?> removeProduct(Long productId) {
        Map<String, Object> resultMap = new HashMap<>();
        Product product = productRepository.findById(productId).orElse(null);
        if (!Objects.isNull(product)) {
            productRepository.delete(product);
            resultMap.put("message", "Product deleted successfully");
        } else
            resultMap.put("message", "Product not found");
        return ResponseEntity.ok().body(resultMap);
    }

    @Transactional
    public ResponseEntity<?> updateProductStatus(Long productId, String productStatus) {
        Map<String, Object> resultMap = new HashMap<>();
        Product product = productRepository.findById(productId).orElse(null);
        if (!Objects.isNull(product)) {
            product.setProductStatus(productStatus);
            ProductResponseDTO updatedProduct = modelMapper.map(productRepository.save(product), ProductResponseDTO.class);
            resultMap.put("message", "Product status update successfully");
            resultMap.put("product", updatedProduct);
        } else
            resultMap.put("message", "Product not found");
        return ResponseEntity.ok().body(resultMap);
    }

    public ResponseEntity<?> getProductStockDetails() {
        List<ProductRepository.ProductStockDetails> productStockDetails = productRepository.getProductStockDetails();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("message", "All product stock details fetch successfully");
        resultMap.put("product_stock_details", productStockDetails);
        return ResponseEntity.ok().body(resultMap);
    }
}
