package model;

import java.security.*;
import java.util.ArrayList;
import java.util.Base64;

public class ReservationsListe {

    private ArrayList<Reservation> reservationen;

    private  Reservation testGebrauch;

    public ReservationsListe()
    {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");

            // Initialize KeyPairGenerator.
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024, random);

            // Generate Key Pairs, a private key and a public key.
            KeyPair keyPair = keyGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();
            Base64.Encoder encoder = Base64.getEncoder();

            String privateKeyE = encoder.encodeToString(privateKey.getEncoded());
            String publicKeyE = encoder.encodeToString(publicKey.getEncoded());

            reservationen = new ArrayList<>();
            Reservation reservation = new Reservation(1, "Alejandro", "Wenzler", "alejandro.wenzler@bluewin.ch", "18:00", "20:00", 101, "Hi", "Shay", publicKeyE, privateKeyE);
            reservationen.add(reservation);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }

    }

    public void add(Reservation reservation){
        reservationen.add(reservation);
    }

    public void delete(Reservation reservation){
        reservationen.remove(reservation);
    }

    public ArrayList<Reservation> getReservationen() {
        return reservationen;
    }

    public void setReservationen(ArrayList<Reservation> reservationen) {
        this.reservationen = reservationen;
    }

    public Reservation getTestGebrauch() {
        return testGebrauch;
    }

    public void setTestGebrauch(Reservation testGebrauch) {
        this.testGebrauch = testGebrauch;
    }
}
