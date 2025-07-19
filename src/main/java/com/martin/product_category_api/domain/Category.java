package com.martin.product_category_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter // Generates all getters
@Setter // Generates all setters
@NoArgsConstructor // Required by JPA: no-argument constructor
@ToString(exclude = {"products"}) // Generates toString(). Be careful with bidirectional relationships, consider excluding them.
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    // @OneToMany annotation to specify the relationship between the Category entity and the Product entity
    // "MappedBy" specifies the name of the attribute in the Product entity that owns the relationship
    @OneToMany(mappedBy = "category") // This tells JPA that the Department entity is the inverse side (non-owning) of the relationship
    private List<Product> products = new ArrayList<>();


}
