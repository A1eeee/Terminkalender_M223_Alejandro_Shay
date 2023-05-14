package controller;

import model.ListKeys;
import model.Reservation;
import model.ReservationsListe;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ViewBean {

    private String keyInput;
    private ListKeys listKeys;

    private ReservationsListe reservationsListe;

    private Reservation reservation;

    public ViewBean(){
        reservation = new Reservation();
    }

    public String CheckKey(){

        if(keyInput.equals(getReservation().getPrivateKey()))
        {
            return "PrivateView.xhtml";

        } else if (keyInput.equals(getReservation().getPublicKey())) {
            return "PublicView.xhtml";
        }

        return null;
    }

    public String getKeyInput() {
        return keyInput;
    }

    public void setKeyInput(String keyInput) {
        this.keyInput = keyInput;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
