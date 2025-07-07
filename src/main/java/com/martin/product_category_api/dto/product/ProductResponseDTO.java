package com.martin.product_category_api.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
