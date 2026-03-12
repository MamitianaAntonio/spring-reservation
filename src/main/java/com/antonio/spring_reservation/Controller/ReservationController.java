import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonio.spring_reservation.model.Reservation;
import com.antonio.spring_reservation.service.ReservationService;

@RestController
@RequestMapping("/booking")
public class ReservationController {
  ReservationService reservationService;
  
  @GetMapping
  public List<Reservation> getAllReservations () {
    try {
      return reservationService.getAllReservations();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @PostMapping
  public void createReservation (@RequestBody Reservation reservation) {
    try {
      reservationService.createReservation(reservation);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}