package model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Reservation {

    private String firstName;
    private String lastName;

    private LocalDate date;
    private String von;
    private String bis;
    private String room;
    private String remark;
    private String participant;

    private String publicKey;
    private String privateKey;

    // Konstruktor, der alle Eigenschaften der Reservierung initialisiert
    public Reservation(String firstName, String lastName, LocalDate date, String von, String bis, String room, String remark, String participant, String publicKey, String privateKey) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.von = von;
        this.bis = bis;
        this.room = room;
        this.remark = remark;
        this.participant = participant;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    // Standardkonstruktor
    public Reservation() {
    }

    // Getter und Setter für die Eigenschaften der Reservierung

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVon() {
        return von;
    }

    public void setVon(String von) {
        this.von = von;
    }

    public String getBis() {
        return bis;
    }

    public void setBis(String bis) {
        this.bis = bis;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }
}

