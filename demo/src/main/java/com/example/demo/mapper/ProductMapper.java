package com.example.demo.mapper;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.response.ProductResponseDto;
import com.example.demo.model.entity.Branch;
import com.example.demo.model.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class ProductMapper {

    @Autowired
    private BranchMapper branchMapper;

    public ProductResponseDto toDTO(Product product) {
        return ProductResponseDto.builder()
                .productId(product.getProductId())
                .sku(product.getSku())
                .title(product.getTitle())
                .unitPrice(product.getUnitPrice())
                .brand(product.getBrand())
                .size(product.getSize())
                .stock(product.getStock())
                .build();
    }

    public List<ProductResponseDto> toDTOs(List<Product> products) {
        if (products == null) {
            return null;
        }

        List<ProductResponseDto> list = new ArrayList<>();
        for (Product product : products) {
            list.add(toDTO(product));
        }
        return list;
    }

    public Product toEntity(ProductDto productDto, Branch branch) {

        return Product.builder()
                .sku(productDto.getSku())
                .title(productDto.getTitle())
                .unitPrice(productDto.getUnitPrice())
                .brand(productDto.getBrand())
                .size(productDto.getSize())
                .stock(productDto.getStock())
                .fkBranchId(branch)
                .build();
    }
}
