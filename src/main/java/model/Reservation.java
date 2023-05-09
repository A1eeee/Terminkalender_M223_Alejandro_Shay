package model;

import java.sql.Time;
import java.util.Date;

public class Reservation {

        private String firstName;
        private String lastName;

        private Date date;
        private String von;
        private String bis;
        private int room;
        private String remark;
        private int participant;

        private String publicKey;
        private String privateKey;

    public Reservation(String firstName, String lastName,Date date, String von, String bis, int room, String remark, int participant, String publicKey, String privateKey) {
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

    public  Reservation(){

    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        privateKey = privateKey;
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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getParticipant() {
        return participant;
    }

    public void setParticipant(int participant) {
        this.participant = participant;
    }
}
