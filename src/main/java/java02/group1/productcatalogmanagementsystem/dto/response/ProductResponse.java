package java02.group1.productcatalogmanagementsystem.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProductResponse {
    private Long id;
    private Long categoryId;
    private String categoryName;

    private String name;

    private BigDecimal price;
    private Integer stockQuantity;
    private String status;
    private boolean outOfStock;

}
