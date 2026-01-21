package java02.group1.productcatalogmanagementsystem.service;

import java02.group1.productcatalogmanagementsystem.dto.request.ProductRequest;
import java02.group1.productcatalogmanagementsystem.dto.response.ProductResponse;
import java02.group1.productcatalogmanagementsystem.entity.Category;
import java02.group1.productcatalogmanagementsystem.entity.Product;
import java02.group1.productcatalogmanagementsystem.repository.CategoryRepository;
import java02.group1.productcatalogmanagementsystem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CloudinaryService cloudinaryService;

    public List<ProductResponse> filterByCategory(Long categoryId) {

        return productRepository.findByCategory_Id(categoryId)
                .stream()
                .map(product -> {
                    ProductResponse dto = new ProductResponse();
                    dto.setId(product.getId());
                    dto.setName(product.getName());
                    dto.setDescription(product.getDescription());
                    dto.setPrice(product.getPrice());
                    dto.setImageUrl(product.getImageUrl());
                    dto.setCategoryName(product.getCategory().getName());
                    return dto;
                })
                .toList();
    }

    //Create Product ( co upload anh )
    public ProductResponse createProduct(ProductRequest dto, MultipartFile image) {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        String imageUrl = cloudinaryService.uploadImage(image);

        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());
        product.setImageUrl(imageUrl);
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        ProductResponse response = new ProductResponse();
        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setDescription(savedProduct.getDescription());
        response.setPrice(savedProduct.getPrice());
        response.setImageUrl(savedProduct.getImageUrl());
        response.setCategoryName(category.getName());

        return response;
    }

}
