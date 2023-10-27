package com.example.demo.service.Impl;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entities.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.ICategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryImpl implements ICategory {

    private final CategoryRepository categoryRepository;

    public CategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(CategoryDto categoryDto) {
        Category category = Category.builder()
                .name(categoryDto.getName())
                .build();
        return categoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    @Override
    public Category findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

}
