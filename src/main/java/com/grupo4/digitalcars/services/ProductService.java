package com.grupo4.digitalcars.services;

import com.grupo4.digitalcars.model.Product;
import com.grupo4.digitalcars.model.Category;
import com.grupo4.digitalcars.model.Transmission;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Integer id);
    List<Product>getProductsByCategory(Category id);
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    void deleteProductById(Integer id);
    List<Product>getProductsByTransmission(Transmission id);
    List<Product> getProductsByRangeDate(LocalDate check_in_date, LocalDate check_out_date);
    List<Product> getProductsByTransmissionAndRangeDate(Integer transmission_id, LocalDate check_in_date, LocalDate check_out_date);
    List<Product> getProductsByKeywordAndDateRange(String keyword, LocalDate startDate, LocalDate endDate);
    List<Product> findByKeyword(String keyword);
    List<Product> getProductsByTransmissionAndKeyword(Transmission transmissionId, String keyword);
    List<Product> getProductsByCategoryAndKeyword(Category categoryId, String keyword);
    List<Product> getProductsByCategoryKeywordAndDateRange(Category categoryId, String keyword, LocalDate startDate, LocalDate endDate);

    List<Product> getRandomProduct();

}
