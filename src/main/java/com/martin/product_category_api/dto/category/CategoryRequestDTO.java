package com.martin.product_category_api.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDTO {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50)
    private String name;
    @NotBlank(message = "Description cannot be blank")
    @Size(min = 10, max = 150)
    private String description;
}
