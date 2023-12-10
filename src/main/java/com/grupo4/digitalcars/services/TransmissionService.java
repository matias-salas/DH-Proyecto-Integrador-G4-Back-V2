package com.grupo4.digitalcars.services;

import com.grupo4.digitalcars.model.Transmission;
import java.util.List;
import java.util.Optional;

public interface TransmissionService {
    List<Transmission> getAllCities();
    Optional<Transmission> getTransmissionById(Integer id);
    Transmission saveTransmission(Transmission transmission);

    Transmission updateTransmission(Transmission transmission);
    void deleteTransmissionById(Integer id);
}
