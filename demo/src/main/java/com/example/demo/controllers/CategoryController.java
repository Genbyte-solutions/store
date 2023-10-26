package com.example.demo.controllers;

import com.example.demo.model.entities.Category;
import com.example.demo.services.ICategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final ICategory categoryService;

    public CategoryController(ICategory categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/category")
    public Category findByName(@RequestParam String categoryName) {
        logger.info(categoryName);
        logger.info("category=> " + categoryService.findByName(categoryName));
        return categoryService.findByName(categoryName);
    }

    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @DeleteMapping("/category/{id}")
    public String DeleteById(@PathVariable String id) {
        categoryService.deleteById(Integer.parseInt(id));
        return "Category has been deleted";
    }
}
