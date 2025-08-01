package com.martin.product_category_api.mapper;

import com.martin.product_category_api.domain.Product;
import com.martin.product_category_api.dto.category.CategoryRefDTO;
import com.martin.product_category_api.dto.product.ProductDetailDTO;
import com.martin.product_category_api.dto.product.ProductRefDTO;
import com.martin.product_category_api.dto.product.ProductRequestDTO;
import com.martin.product_category_api.dto.product.ProductResponseDTO;



public class ProductMapper {


    public static Product fromDTO (ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        return product;
    }

    public static ProductResponseDTO toDTO (Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setPrice(product.getPrice());
        return productResponseDTO;
    }

    public static ProductRefDTO toProductRef (Product product) {
        ProductRefDTO productRefDTO = new ProductRefDTO();
        productRefDTO.setId(product.getId());
        productRefDTO.setName(product.getName());

        return productRefDTO;
    }

    public static ProductDetailDTO toDTOWithCategory(Product product) {
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();

        productDetailDTO.setId(product.getId());
        productDetailDTO.setName(product.getName());
        productDetailDTO.setDescription(product.getDescription());
        productDetailDTO.setPrice(product.getPrice());

        // Convert the Category entity to a CategoryRefDTO
        CategoryRefDTO categoryRefDTO = CategoryMapper.toCategoryRef(product.getCategory());

        // Set the converted category reference in the product detail response DTO
        productDetailDTO.setCategory(categoryRefDTO);

        return productDetailDTO;
    }
}
