package com.example.cgi_resto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ReserveeringController {
    // Et hiljem saaksime andmed frontendi
    private final Reserveeringud reserveeringud = new Reserveeringud();

    @GetMapping("/api/reserveeringud")
    public List<Laud> getLaudadeReserveeringud() {
        return reserveeringud.getReserveeringud();
    }
}
