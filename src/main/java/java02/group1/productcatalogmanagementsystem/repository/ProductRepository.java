package java02.group1.productcatalogmanagementsystem.repository;

import java.util.List;
import java02.group1.productcatalogmanagementsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByStatus(String status);

    // Filter products by categoryId + status
    List<Product> findByStatusAndCategory_Id(String status, Long categoryId);

       //Find Products by Categories
    List<Product> findByCategory_Id(Long categoryId);

}
