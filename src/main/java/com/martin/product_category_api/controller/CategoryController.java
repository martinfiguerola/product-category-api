package com.martin.product_category_api.controller;

import com.martin.product_category_api.dto.category.CategoryRequestDTO;
import com.martin.product_category_api.dto.category.CategoryResponseDTO;
import com.martin.product_category_api.service.category.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory (@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {
        CategoryResponseDTO response = categoryService.save(categoryRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAll () {
        List<CategoryResponseDTO> responseDTOS = categoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getOne (@PathVariable Long id) {
        return categoryService.findById(id)
                .map(categoryResponseDTO -> ResponseEntity.status(HttpStatus.OK).body(categoryResponseDTO))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
