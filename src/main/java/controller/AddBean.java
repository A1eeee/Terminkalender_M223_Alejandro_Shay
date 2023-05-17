package controller;

import model.ListKeys;
import model.Reservation;
import model.ReservationsListe;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.Iterator;
import java.util.List;

@ManagedBean
@RequestScoped
public class AddBean {

    @ManagedProperty(value = "#{reservationsListeBean}")
    private ReservationsListeBean reservationsListeBean;

    private Reservation reservation;

    private ReservationsListe reservationsListe;

    public AddBean() {
        reservation = new Reservation();
    }

    public ReservationsListeBean getReservationsListeBean() {
        return reservationsListeBean;
    }

    public void setReservationsListeBean(ReservationsListeBean reservationsListeBean) {
        this.reservationsListeBean = reservationsListeBean;
    }

    public boolean isRoomSelected(String room) {
        List<Reservation> existingReservations = getReservationsListeBean().getReservationsListe().getReservationen();
        Iterator<Reservation> iterator = existingReservations.iterator();
        while (iterator.hasNext()) {
            Reservation existingReservation = iterator.next();

            if (existingReservation.getRoom().equals(room)) {
                return false;
            }
        }
        return true;
    }




    public String addReservation(){


        reservationsListeBean.getReservationsListe().addR(reservation);

        return "Home.xhtml";
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
