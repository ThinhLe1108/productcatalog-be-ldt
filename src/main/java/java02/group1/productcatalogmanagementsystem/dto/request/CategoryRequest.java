package java02.group1.productcatalogmanagementsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequest {
    @NotBlank(message = "Category name cannot be blank.")
    @Size(min = 3, max = 100, message = "Category name must be between 3 and 100 characters.")
    private String name;

    @Size(max = 500, message = "Description cannot be longer than 500 characters.")
    private String description;
}
