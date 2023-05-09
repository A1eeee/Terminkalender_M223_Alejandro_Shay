package controller;

import model.ListKeys;
import model.Reservation;
import model.ReservationsListe;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AddBean {

    @ManagedProperty(value = "#{reservationsListeBean}")

    private ReservationsListeBean reservationsListeBean;

    private Reservation reservation;

    ListKeys publicKey = new ListKeys();
    ListKeys privateKey = new ListKeys();

    String publicK = publicKey.keyadd();
    String privateK = privateKey.keyadd();



    public AddBean() {
        reservation = new Reservation();
    }

    public ReservationsListeBean getReservationsListeBean() {
        return reservationsListeBean;
    }

    public void setReservationsListeBean(ReservationsListeBean reservationsListeBean) {
        this.reservationsListeBean = reservationsListeBean;
    }

    public String addReservation(){


        reservationsListeBean.getReservationsListe().add(reservation);

        return "list.xhtml";
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
