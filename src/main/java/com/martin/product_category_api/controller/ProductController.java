package com.martin.product_category_api.controller;

import com.martin.product_category_api.dto.product.ProductRequestDTO;
import com.martin.product_category_api.dto.product.ProductResponseDTO;
import com.martin.product_category_api.service.product.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct (@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO responseDTO = productService.save(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll () {
        List<ProductResponseDTO> responseDTOS = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getCategory (@PathVariable Long id) {
        Optional<ProductResponseDTO> responseDTOOptional = productService.findById(id);
        return responseDTOOptional
                .map(productResponseDTO -> ResponseEntity.status(HttpStatus.OK).body(productResponseDTO))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct (@PathVariable Long id, @Valid @RequestBody ProductRequestDTO productRequestDTO) {
        Optional<ProductResponseDTO> responseDTOOptional = productService.update(id, productRequestDTO);

        return responseDTOOptional
                .map(productResponseDTO -> ResponseEntity.status(HttpStatus.OK).body(productResponseDTO))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct (@PathVariable Long id) {
        if (productService.deleteById(id)) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with the given ID does not exist.");

    }
}
