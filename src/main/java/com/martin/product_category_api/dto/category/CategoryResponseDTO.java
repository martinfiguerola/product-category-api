package com.martin.product_category_api.dto.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDTO {

    private Long id;
    private String name;
    private String description;
}
