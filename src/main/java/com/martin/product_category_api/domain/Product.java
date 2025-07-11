package com.martin.product_category_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter // Generates all getters
@Setter // Generates all setters
@NoArgsConstructor // Required by JPA: no-argument constructor
@ToString // Generates ToString(). Be careful with relationships, consider excluding them.
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
