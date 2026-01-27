package java02.group1.productcatalogmanagementsystem.service.implement;

import java02.group1.productcatalogmanagementsystem.dto.request.ProductRequest;
import java02.group1.productcatalogmanagementsystem.dto.request.UpdateProductRequest;
import java02.group1.productcatalogmanagementsystem.dto.response.ProductResponse;

import java.util.List;

public interface ProductServiceImpl {

    List<ProductResponse> getActiveProducts(Long categoryId);

    ProductResponse getActiveProductById(Long id);

    List<ProductResponse> searchActiveProductsByName(String name);

    ProductResponse createProduct(ProductRequest dto);

    ProductResponse updateProduct(Long id, UpdateProductRequest req);

    void deleteProduct(Long id);

}
