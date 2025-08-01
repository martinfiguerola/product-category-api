package com.martin.product_category_api.service.product;

import com.martin.product_category_api.dto.product.ProductDetailDTO;
import com.martin.product_category_api.dto.product.ProductRequestDTO;
import com.martin.product_category_api.dto.product.ProductResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductResponseDTO save (ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> findAll ();
    Optional<ProductDetailDTO> findById (Long id);
    Optional<ProductResponseDTO> update (Long id, ProductRequestDTO productRequestDTO);
    Boolean deleteById (Long id);
}
