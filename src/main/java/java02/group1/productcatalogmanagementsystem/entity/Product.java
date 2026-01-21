package java02.group1.productcatalogmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name: Required
    @Column(nullable = false)
    private String name;

    // Description: detailed info
    @Column(columnDefinition = "TEXT")
    private String description;

    // Price: Required, positive
    @Column(nullable = false)
    private double price;

    // Stock quantity: Required, not negative
    @Column(nullable = false)
    private int stockQuantity;

    // Category: many products belong to one category
    @ManyToOne
    @JoinColumn(name = "categories_id", nullable = false)
    private Category category;
}
