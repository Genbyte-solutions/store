package com.example.demo.model.entities;

import com.example.demo.model.enums.Size;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "sku", nullable = false)
    private String sku;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "Size", nullable = false)
    private Size size;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "fk_category_id", referencedColumnName = "category_id")
    private Category fkCategoryId;

    @ManyToOne
    @JoinColumn(name = "fk_branch_id", referencedColumnName = "branch_id", nullable = false)
    private Branch fkBranchId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Product() {
    }

    public Product(Integer productId, String sku, BigDecimal unitPrice, String brand, Size size, Integer stock, Category fkCategoryId, Branch fkBranchId, Timestamp createdAt, Timestamp updatedAt) {
        this.productId = productId;
        this.sku = sku;
        this.unitPrice = unitPrice;
        this.brand = brand;
        this.size = size;
        this.stock = stock;
        this.fkCategoryId = fkCategoryId;
        this.fkBranchId = fkBranchId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", sku='" + sku + '\'' +
                ", unitPrice=" + unitPrice +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                ", stock=" + stock +
                ", fkCategoryId=" + fkCategoryId +
                ", fkBranchId=" + fkBranchId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Category getFkCategoryId() {
        return fkCategoryId;
    }

    public void setFkCategoryId(Category fkCategoryId) {
        this.fkCategoryId = fkCategoryId;
    }

    public Branch getFkBranchId() {
        return fkBranchId;
    }

    public void setFkBranchId(Branch fkBranchId) {
        this.fkBranchId = fkBranchId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
