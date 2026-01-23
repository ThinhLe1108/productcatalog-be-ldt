package java02.group1.productcatalogmanagementsystem.service;

import java02.group1.productcatalogmanagementsystem.dto.request.CategoryRequest;
import java02.group1.productcatalogmanagementsystem.entity.Category;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java02.group1.productcatalogmanagementsystem.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Transactional
    public List<Category> getCategoriesByName(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Transactional
    public Category create(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category);
    }

    @Transactional
    public Category update(Long id, CategoryRequest updatedCategory) {
        Category existingCategory = getById(id);
        existingCategory.setName(updatedCategory.getName());
        return categoryRepository.save(existingCategory);
    }
}
