package com.example.demo.controller;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entities.Category;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.ICategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final ICategory categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(ICategory categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping("/category")
    public ResponseEntity<?> create(@RequestBody CategoryDto categoryDto) {
        Category category = null;
        category = categoryService.findByName(categoryDto.getName());

        if (category != null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("This category has already exist")
                    .build(), HttpStatus.CONFLICT);
        }

        categoryDto = CategoryDto.builder()
                .categoryId(category.getCategoryId())
                .name(category.getName())
                .build();

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("A new category has been added")
                .object(categoryDto)
                .build(), HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<?> findByName(@RequestParam("categoryName") String categoryName) {
        Category response = null;
        response = categoryService.findByName(categoryName);

        logger.info(categoryName);
        logger.info("category=> " + response);

        if (response == null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Category not found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("")
                .object(response)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> findAll() {
        List<Category> categories = categoryService.findAll();

        if (categories.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("No records found")
                    .object(categories)
                    .build(), HttpStatus.NOT_FOUND);
        }

        List<CategoryDto> categoryDtos = categoryMapper.toDTOs(categories);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(categoryDtos)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> DeleteById(@PathVariable("id") String id) {
        categoryService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
