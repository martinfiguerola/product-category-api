package com.martin.product_category_api.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // Generates all getters
@Setter // Generates all setters
@ToString
public class ProductRefDTO {
    private Long id;
    private String name;
}
