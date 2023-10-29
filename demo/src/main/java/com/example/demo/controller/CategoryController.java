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
        Category findCategory = categoryService.findByName(categoryDto.getName());

        if (findCategory != null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("This category already exist")
                    .build(), HttpStatus.CONFLICT);
        }

        Category category = categoryService.save(categoryDto);

        // converts the entity into dto
        categoryDto = categoryMapper.toDTO(category);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("A new category has been added")
                .object(categoryDto)
                .build(), HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<?> findByName(@RequestParam("categoryName") String categoryName) {
        Category category = categoryService.findByName(categoryName);

        logger.info(categoryName);
        logger.info("category=> " + category);

        if (category == null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Category not found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        // converts the entity into dto
        CategoryDto categoryDto = categoryMapper.toDTO(category);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(category)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> findAll() {
        List<Category> categories = categoryService.findAll();

        if (categories.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("No records found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        List<CategoryDto> categoryDtos = categoryMapper.toDTOs(categories);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(categoryDtos)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
