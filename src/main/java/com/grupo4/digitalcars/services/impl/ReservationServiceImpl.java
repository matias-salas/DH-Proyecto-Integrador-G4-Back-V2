package com.grupo4.digitalcars.services.impl;


import com.grupo4.digitalcars.model.Reservation;
import com.grupo4.digitalcars.repository.ReservationRepository;
import com.grupo4.digitalcars.repository.UserRepository;
import com.grupo4.digitalcars.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Reservation> findByProduct_id(Integer productId) {
        return reservationRepository.findByProduct_Id(productId);
    }

    @Override
    public List<Reservation> findByUser_id(Integer userId) {
        return reservationRepository.findByUser_id(userId);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(Integer id) {
        reservationRepository.deleteById(id);
    }
}
