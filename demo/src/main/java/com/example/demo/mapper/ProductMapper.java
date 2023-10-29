package com.example.demo.mapper;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDTO(Product product);

    List<ProductDto> toDTOs(List<Product> products);

    Product toEntity(ProductDto productDto);
}
