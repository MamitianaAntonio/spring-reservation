package com.antonio.spring_reservation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.antonio.spring_reservation.model.Reservation;
import com.antonio.spring_reservation.service.ReservationService;

@RestController
@RequestMapping("/booking")
public class ReservationController {
  private final ReservationService reservationService;
  
  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }
  
  @GetMapping
  public List<Reservation> getAllReservations () {
    try {
      return reservationService.getAllReservations();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  @PostMapping
  public List<Reservation> createReservation(@RequestBody Reservation reservation) {
    try {
      return reservationService.createReservation(reservation);
    } catch (IllegalArgumentException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    } catch (RuntimeException e) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
    }
  }
}