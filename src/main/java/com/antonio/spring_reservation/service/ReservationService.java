package com.antonio.spring_reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.antonio.spring_reservation.model.Reservation;

@Service
public class ReservationService {
  private final List <Reservation> reservations = new ArrayList<>();

  // methods to get all reservations
  public List<Reservation> getAllReservations () {
    return reservations;
  }  
}
