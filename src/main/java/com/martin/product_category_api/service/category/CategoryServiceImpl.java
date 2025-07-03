package com.martin.product_category_api.service.category;

import com.martin.product_category_api.domain.Category;
import com.martin.product_category_api.dto.category.CategoryRequestDTO;
import com.martin.product_category_api.dto.category.CategoryResponseDTO;
import com.martin.product_category_api.mapper.CategoryMapper;
import com.martin.product_category_api.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryResponseDTO save(CategoryRequestDTO categoryRequestDTO) {

        // Step 1: Retrieve DTO and convert to entity
        Category category = CategoryMapper.fromDTO(categoryRequestDTO);
        // Step 2: Persist the entity in the database
        Category savedCategory = repository.save(category);
        // Step 3: The saved entity we convert to response DTO for client
        return CategoryMapper.toDTO(savedCategory);
    }
}
