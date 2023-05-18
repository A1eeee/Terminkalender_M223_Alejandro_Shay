package controller;

import model.ListKeys;
import model.Reservation;
import model.ReservationsListe;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
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

    // Überprüft den Schlüssel und navigiert entsprechend
    public String CheckKey(){
        this.reservation = reservationsListeBean.getReservationsListe().sReservation(keyInput);

        if(reservation != null){
            if(reservation.getPrivateKey().equals(keyInput))
            {
                return "PrivateView.xhtml"; // Navigiert zur privaten Ansicht

            } else if (reservation.getPublicKey().equals(keyInput)) {
                return "PublicView.xhtml"; // Navigiert zur öffentlichen Ansicht
            }
        }
        return "Home.xhtml"; // Navigiert zur Startseite
    }

    // Löscht eine Reservierung
    public String deleteRes(){
        reservationsListeBean.getReservationsListe().delete(reservation);
        return "Home.xhtml"; // Navigiert zur Startseite
    }

    // Startet den Bearbeitungsmodus für eine Reservierung
    public String startEdit(){
        return "Edit.xhtml"; // Navigiert zur Bearbeitungsseite
    }

    // Speichert die bearbeitete Reservierung
    public String save(){
        reservationsListeBean.getReservationsListe().addModify(reservation);
        return "PrivateView.xhtml"; // Navigiert zur privaten Ansicht
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

