package model;

import java.security.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;

public class ReservationsListe {

    private ArrayList<Reservation> reservationen;


    private ListKeys listKeys;

    public ReservationsListe()
    {
            listKeys = new ListKeys();
            reservationen = new ArrayList<>();
    }

    public void addR(Reservation reservation){

        reservation.setPublicKey(listKeys.keyadd());
        reservation.setPrivateKey(listKeys.keyadd());
        System.out.println("publickey:" + reservation.getPublicKey());
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


}
