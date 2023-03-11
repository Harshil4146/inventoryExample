package com.inventory.example.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponseDTO {

    @JsonProperty(value = "product_name")
    private String productName;
    @JsonProperty(value = "product_category")
    private String productCategory;
    @JsonProperty(value = "product_status")
    private String productStatus;
    @JsonProperty(value = "product_stock")
    private Long productStock;
    @JsonProperty(value = "product_id")
    private Long id;
    @JsonProperty(value = "product_price")
    private Long productPrice;

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Long getProductStock() {
        return productStock;
    }

    public void setProductStock(Long productStock) {
        this.productStock = productStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
