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

    // Überprüft, ob ein Raum bereits ausgewählt  | War eine Idee die schluss endlich nicht Funktionierte, wurde im Projekt gelessen für Zukünftliche versuche oder die Idee weiter zu entwickeln.
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

    // Fügt eine neue Reservierung hinzu
    public String addReservation(){
        // Fügt die Reservierung der Reservationsliste hinzu, die im ReservationsListeBean verwaltet wird
        reservationsListeBean.getReservationsListe().addR(reservation);

        return "Home.xhtml"; // Gibt den Navigationsfall zurück, um zur Home-Seite zu gelangen
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

