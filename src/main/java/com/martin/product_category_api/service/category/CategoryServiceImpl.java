package com.martin.product_category_api.service.category;

import com.martin.product_category_api.domain.Category;
import com.martin.product_category_api.dto.category.CategoryDetailDTO;
import com.martin.product_category_api.dto.category.CategoryRequestDTO;
import com.martin.product_category_api.dto.category.CategoryResponseDTO;
import com.martin.product_category_api.mapper.CategoryMapper;
import com.martin.product_category_api.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public CategoryResponseDTO save(CategoryRequestDTO categoryRequestDTO) {

        // Step 1: Retrieve DTO and convert to entity
        Category category = CategoryMapper.fromDTO(categoryRequestDTO);
        // Step 2: Persist the entity in the database
        Category savedCategory = repository.save(category);
        // Step 3: The saved entity we convert to response DTO for client
        return CategoryMapper.toDTO(savedCategory);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CategoryResponseDTO> findAll() {
        // Step 1: Retrieve all category entities from the database
        List<Category> categories = repository.findAll();

        // Step 2: Convert each entity to DTO and return it
        return categories.stream()
                .map(CategoryMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CategoryDetailDTO> findById(Long id) {
        // Step 1: Fetches a category by its ID from the database.
        Optional<Category> optionalCategory = repository.findById(id);

        // Step 2: If the category is found, convert it to a DTO and returns it.
        // Otherwise, returns an empty Optional.
        return optionalCategory.map(CategoryMapper::toDTOWithProducts);
    }

    @Transactional
    @Override
    public Optional<CategoryResponseDTO> update(Long id, CategoryRequestDTO categoryRequestDTO) {
        // Step 1: Fetches a category by its ID from the database
        Optional<Category> optionalCategory = repository.findById(id);

        // Step 1:  If the category exists, update its fields, save the changes and convert to DTO.
        // Otherwise, the method will return an empty Optional.
        return optionalCategory.map(category -> {
            category.setName(categoryRequestDTO.getName());
            category.setDescription(categoryRequestDTO.getDescription());

            // Persist the updated category entity back to the database.
            Category savedCategory = repository.save(category);

            // Convert the saved entity to a DTO for the response.
            return CategoryMapper.toDTO(savedCategory);
        });
    }

    @Transactional
    @Override
    public Boolean deleteById(Long id) {
        // Step 1: Fetches a category entity by its ID from the database
        Optional<Category> optionalCategory = repository.findById(id);

        // Step 2: If the category exists, delete it and return true.
        // Otherwise, the method will return false.
        return optionalCategory.map(category -> {
            repository.delete(category);
            return true;
        }).orElse(false);
    }


}
