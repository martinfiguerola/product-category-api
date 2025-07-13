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
@ToString(exclude = {"category"}) // Generates ToString(). Be careful with relationships, consider excluding them.
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    // @ManyToOne annotation to specify the relationship between the Product entity and the Category entity.
    // @JoinColumn annotation specifies the name of the foreign key column in the Product table referencing the Category table.
    // @ManyToOne along with @JoinColumn(name = "category_id"), indicates that the Product entity is the owning side of the relationship.
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
