package com.grupo4.digitalcars.services.impl;
import com.grupo4.digitalcars.model.Transmission;
import com.grupo4.digitalcars.repository.TransmissionRepository;
import com.grupo4.digitalcars.services.TransmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransmissionServiceImpl implements TransmissionService {

    @Autowired
    private TransmissionRepository transmissionRepository;

    @Override
    public List<Transmission> getAllCities() {
        return transmissionRepository.findAll();
    }

    @Override
    public Optional<Transmission> getTransmissionById(Integer id) {
        return transmissionRepository.findById(id);
    }

    @Override
    public Transmission saveTransmission(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }
    @Override
    public Transmission updateTransmission(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public void deleteTransmissionById(Integer id) {
        transmissionRepository.deleteById(id);
    }

}
