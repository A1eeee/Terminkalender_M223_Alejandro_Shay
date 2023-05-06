package controller;


import model.ReservationsListe;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager = true)
@ApplicationScoped
public class ReservationsListeBean {

    private ReservationsListe reservationsListe;

    public ReservationsListeBean() {
        reservationsListe = new ReservationsListe();
    }
}
