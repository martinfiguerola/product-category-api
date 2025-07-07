package com.martin.product_category_api.service.product;

import com.martin.product_category_api.domain.Product;
import com.martin.product_category_api.dto.product.ProductRequestDTO;
import com.martin.product_category_api.dto.product.ProductResponseDTO;
import com.martin.product_category_api.mapper.ProductMapper;
import com.martin.product_category_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        // Convert the incoming DTO to a Product entity
        Product product = ProductMapper.fromDTO(productRequestDTO);

        // Persist the Product entity in the database
        Product savedProduct = productRepository.save(product);

        // Convert the persisted Product entity to a DTO for the response
        return ProductMapper.toDTO(savedProduct);
    }
}
