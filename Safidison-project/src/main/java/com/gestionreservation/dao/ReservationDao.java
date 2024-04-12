package com.gestionreservation.dao;

import com.gestionreservation.models.Reservation;
import com.gestionreservation.utils.DatabaseConnection;
import java.sql.*;

public class ReservationDao {
    public int saveReservation(Reservation reservation) {
        int status = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO reservations (clientName, reservationDate, reservationTime) VALUES (?, ?, ?)");
            ps.setString(1, reservation.getClientName());
            ps.setString(2, reservation.getReservationDate());
            ps.setString(3, reservation.getReservationTime());
            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public int updateReservation(Reservation reservation) {
        int status = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE reservations SET clientName=?, reservationDate=?, reservationTime=? WHERE id=?");
            ps.setString(1, reservation.getClientName());
            ps.setString(2, reservation.getReservationDate());
            ps.setString(3, reservation.getReservationTime());
            ps.setInt(4, reservation.getId());
            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public int deleteReservation(int id) {
        int status = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM reservations WHERE id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
