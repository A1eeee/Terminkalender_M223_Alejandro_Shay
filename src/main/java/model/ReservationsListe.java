package model;

import java.security.*;
import java.util.ArrayList;
import java.util.Base64;

public class ReservationsListe {

    private ArrayList<Reservation> reservationen;

    private  Reservation testGebrauch;

    public ReservationsListe()
    {
            reservationen = new ArrayList<>();
    }

    public void add(Reservation reservation){
        reservationen.add(reservation);
    }

    public void delete(Reservation reservation){
        reservationen.remove(reservation);
    }

    public ArrayList<Reservation> getReservationen() {
        return reservationen;
    }

    public void setReservationen(ArrayList<Reservation> reservationen) {
        this.reservationen = reservationen;
    }

    public Reservation getTestGebrauch() {
        return testGebrauch;
    }

    public void setTestGebrauch(Reservation testGebrauch) {
        this.testGebrauch = testGebrauch;
    }
}
