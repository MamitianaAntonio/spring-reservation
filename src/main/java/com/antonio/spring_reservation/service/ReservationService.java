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
  
  // methods to create a reservation
  public void createReservation(Reservation reservation) {
    boolean alreadyExists = reservations.stream()
        .anyMatch(r -> r.getRoomNumber() == reservation.getRoomNumber()
            && r.getReservationDate().equals(reservation.getReservationDate()));
    
    if (alreadyExists) {
      throw new IllegalArgumentException("Room is already booked for the selected date.");
    }

    if (!alreadyExists) {
      reservations.add(reservation);
    }
  }
}
