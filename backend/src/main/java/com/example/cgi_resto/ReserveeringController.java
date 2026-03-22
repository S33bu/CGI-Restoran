package com.example.cgi_resto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

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
    
    @PostMapping("/api/reserveeringud/genereeri")
    public List<Laud> genereeriPäevaReserveeringud(@RequestParam String kuupaev) {
        LocalDate päev = LocalDate.parse(kuupaev);

        Random random = new Random();
        for (Laud laud : reserveeringud.getReserveeringud()) {
            // Iga laud saab 0-3 juhuslikku reserveeringut antud päeval
            int reserveeringuteArv = random.nextInt(4);
            for (int i = 0; i < reserveeringuteArv; i++) {
                int tund = 11 + random.nextInt(11); // Reserveeringud aegade vahemikus 11:00-21:00
                int minut = random.nextBoolean() ? 0 : 30;
                reserveeringud.lisaReserveering(laud.getLauaNr(), päev.atTime(tund, minut)
            );
            }
        }
        return reserveeringud.getReserveeringud();
    }

}
