package com.example.cgi_resto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class ReserveeringController {
    // Et hiljem saaksime andmed frontendi
    private final Reserveeringud reserveeringud = new Reserveeringud();

    @GetMapping("/api/reserveeringud")
    public List<Laud> getLaudadeReserveeringud() {
        return reserveeringud.getReserveeringud();
    }

    @PostMapping("/api/reserveeringud")
    public List<Laud> lisaReserveering(@RequestBody ReserveeringDTO uusReserveering) {
        LocalDateTime reserveeringuAeg = LocalDateTime.parse(
            uusReserveering.getReserveering(),
            DateTimeFormatter.ISO_LOCAL_DATE_TIME //muidu jookseb kokku
        );
        reserveeringud.lisaReserveering(uusReserveering.getLaud(), reserveeringuAeg);
        return reserveeringud.getReserveeringud(); // tagastame uuendatud reserveeringud
        
    }
}
