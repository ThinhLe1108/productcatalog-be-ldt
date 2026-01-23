package java02.group1.productcatalogmanagementsystem.controller;

import java02.group1.productcatalogmanagementsystem.dto.request.CategoryRequest;
import java02.group1.productcatalogmanagementsystem.entity.Category;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java02.group1.productcatalogmanagementsystem.service.CategoryService;

import java.util.List;

@RestController
@SecurityRequirement(name = "api")
@RequestMapping("/api/categories")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/name/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Category> getCategoriesByName(@PathVariable String name) {
        return categoryService.getCategoriesByName(name);
    }

    @GetMapping("/id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Category getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PostMapping("/create")
<<<<<<< src/main/java/java02/group1/productcatalogmanagementsystem/controller/CategoryController.java
    public Category create(@RequestBody CategoryRequest category) {
=======
    @PreAuthorize("hasRole('ADMIN')")
    public Category create(@RequestBody  CategoryRequest category) {
>>>>>>> src/main/java/java02/group1/productcatalogmanagementsystem/controller/CategoryController.java
        return categoryService.create(category);
    }

    @PutMapping("/id/{id}")
<<<<<<< src/main/java/java02/group1/productcatalogmanagementsystem/controller/CategoryController.java
    public Category update(@PathVariable Long id, @RequestBody CategoryRequest updatedCategory) {
=======
    @PreAuthorize("hasRole('ADMIN')")
    public Category update(@PathVariable Long id, @RequestBody CaCategoryRequest pdatedCategory) {
>>>>>>> src/main/java/java02/group1/productcatalogmanagementsystem/controller/CategoryController.java
        return categoryService.update(id, updatedCategory);
    }

}
