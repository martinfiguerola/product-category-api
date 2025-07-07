package com.martin.product_category_api.dto.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ProductRequestDTO {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50)
    private String name;
    private String description;
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal price;
}
