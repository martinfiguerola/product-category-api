package com.martin.product_category_api.mapper;

import com.martin.product_category_api.domain.Category;
import com.martin.product_category_api.dto.category.CategoryRequestDTO;
import com.martin.product_category_api.dto.category.CategoryResponseDTO;

public class CategoryMapper {

    public static Category fromDTO (CategoryRequestDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }

    public static CategoryResponseDTO toDTO (Category category) {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setId(category.getId());
        categoryResponseDTO.setName(category.getName());
        categoryResponseDTO.setDescription(category.getDescription());
        return categoryResponseDTO;
    }
}
