package java02.group1.productcatalogmanagementsystem.service;

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
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public Category update(Long id, Category updatedCategory) {
        Category existingCategory = getById(id);
        existingCategory.setName(updatedCategory.getName());
        existingCategory.setDescription(updatedCategory.getDescription());
        return categoryRepository.save(existingCategory);
    }
}
