package db;

import model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DbConn {

    // Datenbankverbindungsdaten
    private static final String connectURL = "jdbc:mariadb://localhost:3306/terminkalender_m223";
    private static final String user = "root";
    private static final String pw = "";

    private Connection conn;

    public DbConn(){
        try {
            // Stelle eine Verbindung zur Datenbank her
            conn = DriverManager.getConnection(connectURL, user, pw);
        }catch (SQLException e){
            // Wirf eine RuntimeException, wenn die Verbindung fehlschlägt
            throw new RuntimeException(e);
        }
    }

    public void addReservation(Reservation reservation){
        try {
            // Bereite eine SQL-Anweisung vor, um eine neue Reservierung in die Datenbank einzufügen
            PreparedStatement statement = conn.prepareStatement("INSERT INTO reservations (firstname, lastname ,date, von, bis, room, remark, participant, publicKey, privateKey) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?);");

            // Konvertiere das Reservierungsdatum in das Format java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(reservation.getDate());

            // Setze die Parameterwerte für die SQL-Anweisung
            statement.setString(1, reservation.getFirstName());
            statement.setString(2, reservation.getLastName());
            statement.setDate(3, sqlDate);
            statement.setString(4, reservation.getVon());
            statement.setString(5, reservation.getBis());
            statement.setString(6, reservation.getRoom());
            statement.setString(7, reservation.getRemark());
            statement.setString(8, reservation.getParticipant());
            statement.setString(9, reservation.getPublicKey());
            statement.setString(10, reservation.getPrivateKey());

            // Führe die SQL-Anweisung aus, um die Reservierung in die Datenbank einzufügen
            statement.executeUpdate();

            // Schließe das Statement
            statement.close();
        }catch (SQLException e){
            // Wirf eine RuntimeException, wenn ein Fehler während der Datenbankoperation auftritt
            throw new RuntimeException(e);
        }
    }

    public void updateReservation(Reservation reservation){
        try {
            // Bereite eine SQL-Anweisung vor, um eine bestehende Reservierung in der Datenbank zu aktualisieren
            PreparedStatement statement = conn.prepareStatement("UPDATE reservations SET firstname = ?, lastname = ? ,date = ?, von = ?, bis = ?, remark = ?, participant = ? WHERE privateKey = ?");

            // Konvertiere das Reservierungsdatum in das Format java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(reservation.getDate());

            // Setze die Parameterwerte für die SQL-Anweisung
            statement.setString(1, reservation.getFirstName());
            statement.setString(2, reservation.getLastName());
            statement.setDate(3, sqlDate);
            statement.setString(4, reservation.getVon());
            statement.setString(5, reservation.getBis());
            statement.setString(6, reservation.getRemark());
            statement.setString(7, reservation.getParticipant());
            statement.setString(8, reservation.getPrivateKey());

            // Führe die SQL-Anweisung aus, um die Reservierung in der Datenbank zu aktualisieren
            statement.executeUpdate();

            // Schließe das Statement
            statement.close();
        }catch (SQLException e){
            // Wirf eine RuntimeException, wenn ein Fehler während der Datenbankoperation auftritt
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, ArrayList<?>> getAllReservations(){
        // Erstelle leere Listen für Reservierungen und Schlüssel
        ArrayList<Reservation> reservationList = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>();

        // Erstelle eine HashMap, um die Liste der Reservierungen und Schlüssel zu speichern
        HashMap<String, ArrayList<?>> values = new HashMap<>();
        try{
            // Bereite eine SQL-Anweisung vor, um alle Reservierungen aus der Datenbank abzurufen
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM reservations");

            // Führe die SQL-Anweisung aus und erhalte die Ergebnisse
            ResultSet results = statement.executeQuery();

            // Iteriere über die Ergebnisse und erstelle Reservation-Objekte
            while (results.next()){
                Reservation reservation = new Reservation();

                // Konvertiere das SQL-Datum in das Format LocalDate
                java.sql.Date sqlDate = results.getDate("date");
                java.time.LocalDate localDate = sqlDate.toLocalDate();

                // Setze die Attribute des Reservation-Objekts
                reservation.setFirstName(results.getString("firstname"));
                reservation.setLastName(results.getString("lastname"));
                reservation.setDate(localDate);
                reservation.setVon(results.getString("von"));
                reservation.setBis(results.getString("bis"));
                reservation.setRoom(results.getString("room"));
                reservation.setRemark(results.getString("remark"));
                reservation.setParticipant(results.getString("participant"));
                reservation.setPublicKey(results.getString("publicKey"));
                reservation.setPrivateKey(results.getString("privateKey"));

                // Füge das Reservation-Objekt der Liste hinzu
                reservationList.add(reservation);

                // Füge den öffentlichen und privaten Schlüssel der Schlüsselliste hinzu
                keys.add(results.getString("publicKey"));
                keys.add(results.getString("privateKey"));
            }

            // Füge die Liste der Reservierungen und die Schlüsselliste der HashMap hinzu
            values.put("reservations", reservationList);
            values.put("keys", keys);

            // Schließe das Statement
            statement.close();

            // Gib die HashMap zurück, die die Reservierungen und Schlüssel enthält
            return values;

        } catch (SQLException e) {
            // Wirf eine RuntimeException, wenn ein Fehler während der Datenbankoperation auftritt
            throw new RuntimeException(e);
        }
    }

    public void deleteReservationdb(Reservation reservation){
        try {
            // Bereite eine SQL-Anweisung vor, um eine Reservierung aus der Datenbank zu löschen
            PreparedStatement statement = conn.prepareStatement("DELETE FROM reservations WHERE privateKey = ?");
            statement.setString(1, reservation.getPrivateKey());

            // Führe die SQL-Anweisung aus, um die Reservierung aus der Datenbank zu löschen
            statement.executeUpdate();

            // Schließe das Statement
            statement.close();

        } catch (SQLException e) {
            // Wirf eine RuntimeException, wenn ein Fehler während der Datenbankoperation auftritt
            throw new RuntimeException(e);
        }
    }
}
