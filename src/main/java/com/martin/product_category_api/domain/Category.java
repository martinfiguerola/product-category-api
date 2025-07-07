package com.martin.product_category_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@Getter // Generates all getters
@Setter // Generates all setters
@NoArgsConstructor // Required by JPA: no-argument constructor
@ToString // Generates toString(). Be careful with bidirectional relationships, consider excluding them.
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


}
