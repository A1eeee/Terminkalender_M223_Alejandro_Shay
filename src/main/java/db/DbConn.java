package db;

import model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DbConn {

    private static final String connectURL = "jdbc:mariadb://localhost:3306/terminkalender_m223";
    private static final String user = "root";
    private static final String pw = "";

    private Connection conn;

    public DbConn(){
        try {
            conn = DriverManager.getConnection(connectURL, user, pw);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void addReservation(Reservation reservation){
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO reservations (firstname, lastname ,date, von, bis, room, remark, participant, publicKey, privateKey) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?);");

            java.sql.Date sqlDate = java.sql.Date.valueOf(reservation.getDate());

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

            statement.executeUpdate();

            statement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateReservation(Reservation reservation){
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE reservations SET firstname = ?, lastname = ? ,date = ?, von = ?, bis = ?, remark = ?, participant = ? WHERE privateKey = ?");

            java.sql.Date sqlDate = java.sql.Date.valueOf(reservation.getDate());

            statement.setString(1, reservation.getFirstName());
            statement.setString(2, reservation.getLastName());
            statement.setDate(3, sqlDate);
            statement.setString(4, reservation.getVon());
            statement.setString(5, reservation.getBis());
            statement.setString(6, reservation.getRemark());
            statement.setString(7, reservation.getParticipant());
            statement.setString(8, reservation.getPrivateKey());

            statement.executeUpdate();

            statement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, ArrayList<?>> getAllReservations(){
        ArrayList<Reservation> reservationList = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>();
        HashMap<String, ArrayList<?>> values = new HashMap<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM reservations");

            ResultSet results = statement.executeQuery();

            while (results.next()){
                Reservation reservation = new Reservation();

                java.sql.Date sqlDate = results.getDate("date");
                java.time.LocalDate localDate = sqlDate.toLocalDate();

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

                reservationList.add(reservation);

                keys.add(results.getString("publicKey"));
                keys.add(results.getString("privateKey"));
            }

            values.put("reservations", reservationList);
            values.put("keys", keys);
            statement.close();
            return values;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteReservationdb(Reservation reservation){
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM reservations WHERE privateKey = ?");
            statement.setString(1, reservation.getPrivateKey());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
