package com.example.cgi_resto;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Laud {
    private int lauaNr;
    private int kohtadeArv;
    private ArrayList<LocalDateTime> reserveeringud;

    public Laud(int lauaNr, int kohtadeArv, ArrayList<LocalDateTime> reserveeringud) {
        this.lauaNr = lauaNr;
        this.kohtadeArv = kohtadeArv;
        this.reserveeringud = new ArrayList<>(reserveeringud);
    }

    public int getLauaNr() {
        return lauaNr;
    }

    public ArrayList<LocalDateTime> getReserveeringud() {
        return reserveeringud;
    }

    public int getKohtadeArv() {
        return kohtadeArv;
    }

    public void lisaReserveering(LocalDateTime reserveering) {
        reserveeringud.add(reserveering);
    }

    public boolean onVaba(LocalDateTime soovitudAeg) {
        // Kontrollime, kas valitud aeg on broneeritud ajast vähemalt 2 tundi vähem või rohkem (broneering kehtib 2 tundi)
        return reserveeringud.stream().noneMatch(reserveering -> 
            reserveering.isAfter(soovitudAeg.minusHours(2)) && reserveering.isBefore(soovitudAeg.plusHours(2))
        );
    }
}
