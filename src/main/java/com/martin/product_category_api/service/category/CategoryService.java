package com.martin.product_category_api.service.category;

import com.martin.product_category_api.dto.category.CategoryRequestDTO;
import com.martin.product_category_api.dto.category.CategoryResponseDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryResponseDTO save (CategoryRequestDTO categoryRequestDTO);
    List<CategoryResponseDTO> findAll ();
    Optional<CategoryResponseDTO> findById (Long id);
    Optional<CategoryResponseDTO> update (Long id, CategoryRequestDTO categoryRequestDTO);
    Boolean deleteById (Long id);

}
