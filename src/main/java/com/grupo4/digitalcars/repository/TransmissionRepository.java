package com.grupo4.digitalcars.repository;

import com.grupo4.digitalcars.model.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {
}
