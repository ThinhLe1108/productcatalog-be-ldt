package java02.group1.productcatalogmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Products", indexes = {
        @Index(name = "IX_Products_Name", columnList = "name"),
        @Index(name = "IX_Products_Status", columnList = "status"),
        @Index(name = "IX_Products_CategoryId", columnList = "categories_id")
})
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name: Required
    @Column(nullable = false, length = 200)
    private String name;

    // Description: detailed info
    // SQL Server: NVARCHAR(MAX) phù hợp hơn TEXT
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;

    // Price: Required, positive
    @Column(nullable = false)
    private double price;

    // Stock quantity: Required, not negative
    @Column(nullable = false)
    private int stockQuantity;

    // ✅ only new field: status default ACTIVE
    @Column(nullable = false, length = 30)
    private String status = "ACTIVE";

    @Column
    private String imageUrl;

    // Category: many products belong to one category
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categories_id", nullable = false)
    private Category category;

    @PrePersist
    void prePersist() {
        if (status == null || status.isBlank()) {
            status = "ACTIVE";
        }
    }
}
