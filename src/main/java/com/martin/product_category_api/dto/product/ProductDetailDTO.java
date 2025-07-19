package com.martin.product_category_api.dto.product;

import com.martin.product_category_api.domain.Category;
import com.martin.product_category_api.dto.category.CategoryRefDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter // Generates all getters
@Setter // Generates all setters
@ToString
public class ProductDetailDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryRefDTO category;
}
