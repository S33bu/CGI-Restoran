package com.example.cgi_resto;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class Reserveeringud {


    // et uued reserveeringud ei läheks kaduma, hoiame neid mälus
    private final List<Laud> lauad = initDemoReserveeringud();
    
    public List<Laud> getReserveeringud(){
        return lauad; 
    }

    public void lisaReserveering(int lauaNr, LocalDateTime aeg) {
        for (Laud laud : lauad) {
            if (laud.getLauaNr() == lauaNr) {
                laud.lisaReserveering(aeg);
                break;
            }
        }
    }

    public List<Laud> initDemoReserveeringud() {
        
        Laud laud1 = new Laud(1, 2, new ArrayList<>());
        Laud laud2 = new Laud(2, 2, new ArrayList<>());
        Laud laud3 = new Laud(3, 2, new ArrayList<>());
        Laud laud4 = new Laud(4, 4, new ArrayList<>());
        Laud laud5 = new Laud(5, 4, new ArrayList<>());
        Laud laud6 = new Laud(6, 4, new ArrayList<>());
        Laud laud7 = new Laud(7, 6, new ArrayList<>());
        Laud laud8 = new Laud(8, 6, new ArrayList<>());
        Laud laud9 = new Laud(9, 6, new ArrayList<>());
        Laud laud10 = new Laud(10, 8, new ArrayList<>());


        // Laudade reserveeringud genereeritud GPT-4.1 abil. 
        // Samuti "hardcoded" reserveeringud, mille tõttu saab kergemini testida, kas laud on vaba või mitte, sest teame nende reserveeringute aegu.

        // Laud 1
        laud1.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 1, 18, 0));
        laud1.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 3, 19, 0));
        laud1.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 5, 20, 0));
        laud1.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 7, 17, 30));
        laud1.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 9, 18, 30));

        // Laud 2
        laud2.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 2, 18, 0));
        laud2.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 4, 19, 0));
        laud2.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 6, 20, 0));
        laud2.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 8, 17, 30));
        laud2.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 10, 18, 30));

        // Laud 3
        laud3.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 3, 18, 0));
        laud3.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 6, 19, 0));
        laud3.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 9, 20, 0));
        laud3.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 12, 17, 30));
        laud3.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 15, 18, 30));

        // Laud 4
        laud4.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 4, 18, 0));
        laud4.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 8, 19, 0));
        laud4.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 12, 20, 0));
        laud4.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 16, 17, 30));
        laud4.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 20, 18, 30));

        // Laud 5
        laud5.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 5, 18, 0));
        laud5.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 10, 19, 0));
        laud5.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 15, 20, 0));
        laud5.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 20, 17, 30));
        laud5.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 25, 18, 30));

        // Laud 6
        laud6.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 6, 18, 0));
        laud6.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 12, 19, 0));
        laud6.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 18, 20, 0));
        laud6.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 24, 17, 30));
        laud6.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 30, 18, 30));

        // Laud 7
        laud7.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 7, 18, 0));
        laud7.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 14, 19, 0));
        laud7.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 21, 20, 0));
        laud7.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 28, 17, 30));
        laud7.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 31, 18, 30));

        // Laud 8
        laud8.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 8, 18, 0));
        laud8.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 16, 19, 0));
        laud8.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 24, 20, 0));
        laud8.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 28, 17, 30));
        laud8.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 30, 18, 30));

        // Laud 9
        laud9.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 9, 18, 0));
        laud9.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 18, 19, 0));
        laud9.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 27, 20, 0));
        laud9.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 29, 17, 30));
        laud9.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 31, 18, 30));

        // Laud 10
        laud10.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 10, 18, 0));
        laud10.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 15, 19, 0));
        laud10.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 20, 20, 0));
        laud10.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 25, 17, 30));
        laud10.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 30, 18, 30));

        return Arrays.asList(laud1, laud2, laud3, laud4, laud5, laud6, laud7, laud8, laud9, laud10);
    }
}
