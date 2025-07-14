package com.martin.product_category_api.dto.category;

import com.martin.product_category_api.dto.product.ProductRefDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter // Generates all getters
@Setter // Generates all setters
public class CategoryDetailDTO {
    private Long id;
    private String name;
    private String description;
    private List<ProductRefDTO> productRefDTOS = new ArrayList<>();
}
