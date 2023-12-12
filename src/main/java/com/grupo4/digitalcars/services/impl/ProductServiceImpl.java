package com.grupo4.digitalcars.services.impl;
import com.grupo4.digitalcars.model.Product;
import com.grupo4.digitalcars.model.Category;
import com.grupo4.digitalcars.model.Transmission;
import com.grupo4.digitalcars.repository.ProductRepository;
import com.grupo4.digitalcars.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByCategory(Category id) {
        return productRepository.getByCategory(id);
    }

    public List<Product> getProductsByTransmission(Transmission id)  { return productRepository.getByTransmission(id);
    }

    @Override
    public List<Product> getProductsByRangeDate(LocalDate check_in_date, LocalDate check_out_date) {
        //System.out.println(check_in_date + " --- " + check_out_date);
        return productRepository.getByRangeDate(check_in_date,check_out_date);
    }

    @Override
    public List<Product> getProductsByTransmissionAndRangeDate(Integer transmission_id, LocalDate check_in_date, LocalDate check_out_date) {
        return productRepository.getByTransmissionAndRangeDate(transmission_id, check_in_date,check_out_date);
    }

    @Override
    public List<Product> getProductsByKeywordAndDateRange(String keyword, LocalDate startDate, LocalDate endDate) {
        return productRepository.findByKeywordAndDateRange(keyword, startDate, endDate);
    }

    @Override
    public List<Product> findByKeyword(String keyword) {
        return productRepository.findByKeyword(keyword);
    }

    @Override
    public List<Product> getProductsByTransmissionAndKeyword(Transmission transmissionId, String keyword) {
        return productRepository.findByTransmissionAndKeyword(transmissionId, keyword);
    }


    @Override
    public List<Product> getProductsByCategoryAndKeyword(Category categoryId, String keyword) {
        return productRepository.findByCategoryAndKeyword(categoryId, keyword);
    }


    @Override
    public List<Product> getProductsByCategoryKeywordAndDateRange(Category categoryId, String keyword, LocalDate startDate, LocalDate endDate) {
        return productRepository.findByCategoryKeywordAndDateRange(categoryId, keyword, startDate, endDate);
    }

    @Override
    public List<Product> getRandomProduct() {
        return productRepository.getRandomProduct();
    }
}
