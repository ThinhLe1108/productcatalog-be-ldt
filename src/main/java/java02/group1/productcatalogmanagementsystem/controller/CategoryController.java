package java02.group1.productcatalogmanagementsystem.controller;

import java02.group1.productcatalogmanagementsystem.dto.request.CategoryRequest;
import java02.group1.productcatalogmanagementsystem.entity.Category;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java02.group1.productcatalogmanagementsystem.service.CategoryService;

import java.util.List;

@RestController
@SecurityRequirement(name = "api")
@RequestMapping("/api/categories")
@RequiredArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/name/{name}")
    public List<Category> getCategoriesByName(@PathVariable String name) {
        return categoryService.getCategoriesByName(name);
    }

    @GetMapping("/id/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PostMapping("/create")
    public Category create(@RequestBody CategoryRequest category) {
        return categoryService.create(category);
    }

    @PutMapping("/id/{id}")
    public Category update(@PathVariable Long id, @RequestBody CategoryRequest updatedCategory) {
        return categoryService.update(id, updatedCategory);
    }

}
