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
    public void delete(Reservation reservation){
        reservationen.remove(reservation);
    }
    public void addR(Reservation reservation){

        reservation.setPublicKey(listKeys.keyadd());
        reservation.setPrivateKey(listKeys.keyadd());
        reservationen.add(reservation);
    }

    public void addModify(Reservation reservation){
        reservationen.remove(reservation);
        reservationen.add(reservation);
    }



    public Reservation sReservation(String key){

        Iterator<Reservation> iterator = reservationen.iterator();

        while(iterator.hasNext()){

            Reservation keyR = iterator.next();

            if(keyR.getPrivateKey().equals(key) || keyR.getPublicKey().equals(key)){
                return keyR;
            }

        }
        return null;
    }

    public ArrayList<Reservation> getReservationen() {
        return reservationen;
    }

    public void setReservationen(ArrayList<Reservation> reservationen) {
        this.reservationen = reservationen;

    }


}
