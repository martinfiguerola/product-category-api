package com.martin.product_category_api.service.product;

import com.martin.product_category_api.domain.Product;
import com.martin.product_category_api.dto.product.ProductRequestDTO;
import com.martin.product_category_api.dto.product.ProductResponseDTO;
import com.martin.product_category_api.mapper.ProductMapper;
import com.martin.product_category_api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        // Convert the incoming DTO to a Product entity
        Product product = ProductMapper.fromDTO(productRequestDTO);

        // Persist the Product entity in the database
        Product savedProduct = productRepository.save(product);

        // Convert the persisted Product entity to a DTO for the response
        return ProductMapper.toDTO(savedProduct);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponseDTO> findAll() {
        // Retrieve all products entities from the database.
        List<Product> products = productRepository.findAll();

        // Convert each entity to DTO and collect into a list.
        return products.stream()
                .map(ProductMapper::toDTO)
                .toList();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ProductResponseDTO> findById(Long id) {
        // Fetch the Product entity by its ID from the database
        Optional<Product> optionalProduct = productRepository.findById(id);

        // If the product is found, convert it to a DTO; otherwise, the Optional remains empty.
        return optionalProduct.map(ProductMapper::toDTO);

    }

    @Transactional
    @Override
    public Optional<ProductResponseDTO> update(Long id, ProductRequestDTO productRequestDTO) {
        // Fetch the Product entity by its ID from the database.
        Optional<Product> optionalProduct = productRepository.findById(id);

        // If the Product exists, update its fields, save the changes and convert to DTO.
        // Otherwise, the Optional remains empty
        return optionalProduct.map(product -> {
            product.setName(productRequestDTO.getName());
            product.setDescription(productRequestDTO.getDescription());
            product.setPrice(productRequestDTO.getPrice());

            Product updatedProduct = productRepository.save(product);

            return ProductMapper.toDTO(updatedProduct);
        });
    }

    @Transactional
    @Override
    public Boolean deleteById(Long id) {
        // Fetch the Product entity by its ID from the database.
        Optional<Product> optionalProduct = productRepository.findById(id);

        // If the Product entity exists, delete it and return true
        // Otherwise, the method will return false.
        return optionalProduct.map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
    }
}
