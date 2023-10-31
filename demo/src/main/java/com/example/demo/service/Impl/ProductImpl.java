package com.example.demo.service.Impl;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.IProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements IProduct {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        return productRepository.save(product);
    }

    @Override
    public Product findBySku(String sku) {
        return productRepository.findBySku(sku);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
