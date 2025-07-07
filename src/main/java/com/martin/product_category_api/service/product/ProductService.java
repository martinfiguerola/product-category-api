package com.martin.product_category_api.service.product;

import com.martin.product_category_api.dto.product.ProductRequestDTO;
import com.martin.product_category_api.dto.product.ProductResponseDTO;

public interface ProductService {

    ProductResponseDTO save (ProductRequestDTO productRequestDTO);
}
