package com.example.demo.mapper;

import com.example.demo.model.dto.ProductDto;
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

        List<ProductDto> list = new ArrayList<>(products.size());
        for (Product product : products) {
            list.add(toDTO(product));
        }
        return list;
    }

    public abstract Product toEntity(ProductDto productDto);
}
