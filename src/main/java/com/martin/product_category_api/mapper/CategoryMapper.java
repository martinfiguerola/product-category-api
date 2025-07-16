package com.martin.product_category_api.mapper;

import com.martin.product_category_api.domain.Category;
import com.martin.product_category_api.domain.Product;
import com.martin.product_category_api.dto.category.CategoryDetailDTO;
import com.martin.product_category_api.dto.category.CategoryRequestDTO;
import com.martin.product_category_api.dto.category.CategoryResponseDTO;
import com.martin.product_category_api.dto.product.ProductRefDTO;

import java.util.ArrayList;
import java.util.List;

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

    public static CategoryDetailDTO toDTOWithProducts (Category category) {
        CategoryDetailDTO categoryDetailDTO = new CategoryDetailDTO();
        categoryDetailDTO.setId(category.getId());
        categoryDetailDTO.setName(category.getName());
        categoryDetailDTO.setDescription(category.getDescription());

        // Convert the list of Product entities to a list of ProductRefDTOs
        List<Product> products = category.getProducts();

        List<ProductRefDTO> productRefDTOS = products.stream()
                .map(ProductMapper::toProductRef)
                .toList();
        // Set the converted product references in the DTO
        categoryDetailDTO.setProducts(productRefDTOS);

        return categoryDetailDTO;
    }
}
