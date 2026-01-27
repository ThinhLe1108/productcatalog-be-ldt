package java02.group1.productcatalogmanagementsystem.service.implement;

import java02.group1.productcatalogmanagementsystem.dto.request.CategoryRequest;
import java02.group1.productcatalogmanagementsystem.entity.Category;

import java.util.List;

public interface CategoryServiceImpl {

    List<Category> getAllCategories();

    List<Category> getCategoriesByName(String name);

    Category getById(Long id);

    Category create(CategoryRequest categoryRequest);

    Category update(Long id, CategoryRequest updatedCategory);

    void deleteCategory(Long id);

}
