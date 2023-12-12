package com.grupo4.digitalcars.repository;

import com.grupo4.digitalcars.model.Product;
import com.grupo4.digitalcars.model.Category;
import com.grupo4.digitalcars.model.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> getByCategory(Category id);
    List<Product> getByTransmission(Transmission id);

    @Query(value = "select P.* from product P where P.id not in (select distinct R.product_id from reservation R where (R.checkout_date >= ?1 and R.check_in_date <= ?2));", nativeQuery = true)
    List<Product> getByRangeDate(LocalDate check_in_date, LocalDate check_out_date);

    @Query(value = "select P.* from product P where P.transmission_id = ?1 and P.id not in (select distinct R.product_id from reservation R where (R.checkout_date >= ?2 and R.check_in_date <= ?3));", nativeQuery = true)
    List<Product> getByTransmissionAndRangeDate(Integer transmission_id, LocalDate check_in_date, LocalDate check_out_date);
    
    @Query(value = "SELECT * FROM product ORDER BY RAND() LIMIT 6", nativeQuery = true)
    List<Product> getRandomProduct();

    @Query(value = "SELECT P.* FROM product P WHERE (P.address LIKE %?1% OR P.name LIKE %?1% OR P.description LIKE %?1%) AND P.id NOT IN (SELECT DISTINCT R.product_id FROM reservation R WHERE (R.checkout_date >= ?2 AND R.check_in_date <= ?3))", nativeQuery = true)
    List<Product> findByKeywordAndDateRange(String keyword, LocalDate checkInDate, LocalDate checkOutDate);
    
}

