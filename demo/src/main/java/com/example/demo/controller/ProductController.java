package com.example.demo.controller;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entities.Product;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.IProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class ProductController {

    private final IProduct productService;
    private final ProductMapper productMapper;

    public ProductController(IProduct productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping("/product")
    public ResponseEntity<?> create(@RequestBody ProductDto productDto) {

        Product findProduct = productService.findBySku(productDto.getSku());

        if (findProduct != null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("This product already exist")
                    .build(), HttpStatus.CONFLICT);
        }

        Product product = productService.save(productDto);

        // converts the entity into dto
        productDto = productMapper.toDTO(product);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("A new product has been added")
                .object(productDto)
                .build(), HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<?> findBySku(@RequestParam("sku") String sku) {
        Product product = productService.findBySku(sku);

        if (product == null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Product not found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        // converts the entity into dto
        ProductDto productDto = productMapper.toDTO(product);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(productDto)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/Products")
    public ResponseEntity<?> findAll() {
        List<Product> products = productService.findAll();

        if (products.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("No records found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        List<ProductDto> productDtos = productMapper.toDTOs(products);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(productDtos)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
