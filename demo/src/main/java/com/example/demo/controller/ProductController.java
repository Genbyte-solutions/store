package com.example.demo.controller;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.response.ProductResponseDto;
import com.example.demo.model.entity.Branch;
import com.example.demo.model.entity.Product;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.IBranch;
import com.example.demo.service.IProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final IProduct productService;

    private final IBranch branchServoce;
    private final ProductMapper productMapper;

    public ProductController(IProduct productService, IBranch branchServoce, ProductMapper productMapper) {
        this.productService = productService;
        this.branchServoce = branchServoce;
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

        Branch branch = branchServoce.findById(productDto.getFkBranchId().getBranchId());
        if (branch == null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Branch not found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        ProductResponseDto productResponseDto = productMapper.toDTO(
                productService.save(productDto, branch));

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("A new product has been added")
                .object(productResponseDto)
                .build(), HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<?> findByTitleOrSku(@RequestParam("search") String search) {
        List<Product> products = productService.findByTitleOrSku(search);

        if (products.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Product not found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        List<ProductResponseDto> productResponseDtos = productMapper.toDTOs(products);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(productResponseDtos)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> findAll() {
        List<Product> products = productService.findAll();

        if (products.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("No records found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        List<ProductResponseDto> productResponseDtos = productMapper.toDTOs(products);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(productResponseDtos)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}