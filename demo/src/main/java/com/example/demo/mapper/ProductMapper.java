package com.example.demo.mapper;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Branch;
import com.example.demo.model.entity.Product;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    public abstract ProductDto toDTO(Product product);

    public List<ProductDto> toDTOs(List<Product> products) {
        if (products == null) {
            return null;
        }

        List<ProductDto> list = new ArrayList<>();
        for (Product product : products) {
            list.add(toDTO(product));
        }
        return list;
    }

    public Product toEntity(ProductDto productDto, Branch branch) {
        return Product.builder()
                .sku(productDto.getSku())
                .unitPrice(productDto.getUnitPrice())
                .brand(productDto.getBrand())
                .size(productDto.getSize())
                .stock(productDto.getStock())
                .fkBranchId(branch)
                .build();
    }
}
