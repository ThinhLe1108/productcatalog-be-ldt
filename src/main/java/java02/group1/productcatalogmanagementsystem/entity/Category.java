package java02.group1.productcatalogmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    List<Product> products;
}
