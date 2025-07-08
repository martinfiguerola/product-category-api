package com.martin.product_category_api.service.product;

import com.martin.product_category_api.dto.product.ProductRequestDTO;
import com.martin.product_category_api.dto.product.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO save (ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> findAll ();
}
