package com.antonio.spring_reservation.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
  private String customerName;
  private String customerPhoneNumber;
  private String email;
  private int roomNumber;
  private LocalDate reservationDate; 
}