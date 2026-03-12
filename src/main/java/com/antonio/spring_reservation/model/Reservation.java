package com.antonio.spring_reservation.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
  private String phoneNumber;
  private String email;
  private Integer roomNumber;
  private String roomDescription;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate reservationDate;
}