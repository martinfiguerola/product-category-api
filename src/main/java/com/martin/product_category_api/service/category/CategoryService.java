package com.martin.product_category_api.service.category;

import com.martin.product_category_api.dto.category.CategoryRequestDTO;
import com.martin.product_category_api.dto.category.CategoryResponseDTO;

public interface CategoryService {

    CategoryResponseDTO save (CategoryRequestDTO categoryRequestDTO);
}
