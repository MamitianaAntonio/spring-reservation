package com.antonio.spring_reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.antonio.spring_reservation.model.Reservation;

@Service
public class ReservationService {
  private final List<Reservation> reservations = new ArrayList<>();

  // methods to get all reservations
  public List<Reservation> getAllReservations() {
    return reservations;
  }

  // methods to create a reservation
  public List<Reservation> createReservation(Reservation reservation) {
    if (reservation.getRoomNumber() < 1 || reservation.getRoomNumber() > 9) {
      throw new IllegalArgumentException("Room number must be between 1 and 9");
    }

    boolean alreadyExists = reservations.stream()
        .anyMatch(r -> r.getRoomNumber() == reservation.getRoomNumber()
            && r.getReservationDate().equals(reservation.getReservationDate()));

    if (alreadyExists) {
      throw new RuntimeException("Room is already booked for the selected date.");
    }

    reservations.add(reservation);
    return reservations;
  }
}
