package com.grupo4.digitalcars.repository;

import com.grupo4.digitalcars.model.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Integer> {
    @Query(value = "SELECT S.* FROM spec S WHERE S.icon = ?1", nativeQuery = true)
    Optional<ProductAttribute> getByIcon(String icon);
}
