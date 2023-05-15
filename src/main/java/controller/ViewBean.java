package controller;

import model.ListKeys;
import model.Reservation;
import model.ReservationsListe;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ViewBean {

    @ManagedProperty(value = "#{reservationsListeBean}")
    private ReservationsListeBean reservationsListeBean;

    private String keyInput;
    private ListKeys listKeys;

    private ReservationsListe reservationsListe;

    private Reservation reservation;

    public ViewBean(){
        this.reservation = new Reservation();
    }

    public String CheckKey(){

        this.reservation = reservationsListeBean.getReservationsListe().sReservation(keyInput);

        if(reservation != null){
            if(reservation.getPrivateKey().equals(keyInput))
            {
                return "PrivateView.xhtml";

            } else if (reservation.getPublicKey().equals(keyInput)) {
                return "PublicView.xhtml";
            }
        }
        return "Home.xhtml";
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

    public ReservationsListeBean getReservationsListeBean() {
        return reservationsListeBean;
    }

    public void setReservationsListeBean(ReservationsListeBean reservationsListeBean) {
        this.reservationsListeBean = reservationsListeBean;
    }
}
