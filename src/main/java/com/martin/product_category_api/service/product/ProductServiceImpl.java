package com.martin.product_category_api.service.product;

import com.martin.product_category_api.domain.Category;
import com.martin.product_category_api.domain.Product;
import com.martin.product_category_api.dto.product.ProductDetailDTO;
import com.martin.product_category_api.dto.product.ProductRequestDTO;
import com.martin.product_category_api.dto.product.ProductResponseDTO;
import com.martin.product_category_api.mapper.ProductMapper;
import com.martin.product_category_api.repository.CategoryRepository;
import com.martin.product_category_api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        // Step 1:  Convert the incoming DTO to a Product entity (without the category entity yet)
        // The mapper should only handle mapping basic fields from DTO to entity.
        Product product = ProductMapper.fromDTO(productRequestDTO);

        // Step 2: Retrieve the Category ID using the category from the productRequestDTO
        Long categoryId = productRequestDTO.getCategory();

        // Step 3: .orElseThrow() to handle the case where the category does not exist
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new IllegalArgumentException("Category with: " + categoryId + " not found."));

        // Step 4: Assign the retrieve the Category entity to the Product entity.
        product.setCategory(category);

        // Step 5: Persist the Product entity in the database
        Product savedProduct = productRepository.save(product);

        // Step 6: Convert the persisted Product entity to a DTO for the response
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
    public Optional<ProductDetailDTO> findById(Long id) {
        // 1. Fetch the Product entity by its ID from the database
        Optional<Product> optionalProduct = productRepository.findById(id);

        // 2. If the product is found, convert it to a DTO with category
        // 3. Otherwise, the Optional remains empty.
         return optionalProduct.map(ProductMapper::toDTOWithCategory);
    }

    @Transactional
    @Override
    public Optional<ProductResponseDTO> update(Long id, ProductRequestDTO productRequestDTO) {
        // Step 1: Fetch the Product entity by its ID from the database.
        Optional<Product> optionalProduct = productRepository.findById(id);

        // If the Product exists, update its fields, save the changes and convert to DTO.
        // Otherwise, the Optional remains empty
        return optionalProduct.map(product -> {
            product.setName(productRequestDTO.getName());
            product.setDescription(productRequestDTO.getDescription());
            product.setPrice(productRequestDTO.getPrice());

            // Retrieve the Category ID using the category from the productRequestDTO
            Long categoryId = productRequestDTO.getCategory();

            // .orElseThrow() to handle the case where the category does not exist
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new IllegalArgumentException("Category with: " + categoryId + " not found."));

            // Assign the retrieve the Category entity to the Product entity.
            product.setCategory(category);

            // Persist the updated Product entity in the database
            Product updatedProduct = productRepository.save(product);

            // Return the persisted Product entity to a DTO for the response
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
