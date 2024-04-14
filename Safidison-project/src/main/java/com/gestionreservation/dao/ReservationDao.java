package com.gestionreservation.dao;

import com.gestionreservation.models.Reservation;
import com.gestionreservation.utils.DatabaseConnection;
import java.sql.*;

public class ReservationDao {
	public int saveReservation(Reservation reservation) {
	    int status = 0;
	    ResultSet generatedKeys = null;
	    try {
	        Connection conn = DatabaseConnection.getConnection();
	        PreparedStatement ps = conn.prepareStatement(
	            "INSERT INTO reservations (clientName, reservationDate, reservationTime) VALUES (?, ?, ?)",
	            Statement.RETURN_GENERATED_KEYS);
	        ps.setString(1, reservation.getClientName());
	        ps.setDate(2, reservation.getReservationDate());
	        ps.setString(3, reservation.getReservationTime());
	        status = ps.executeUpdate();

	        generatedKeys = ps.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            reservation.setId(generatedKeys.getInt(1));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (generatedKeys != null) try { generatedKeys.close(); } catch (SQLException logOrIgnore) {}
	    }
	    return status;
	}

	public int updateReservation(Reservation reservation) {
	    int status = 0;
	    String query = "UPDATE reservations SET reservationDate=?, reservationTime=? WHERE id=? AND clientName=?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setDate(1, reservation.getReservationDate());
	        ps.setString(2, reservation.getReservationTime());
	        ps.setInt(3, reservation.getId());
	        ps.setString(4, reservation.getClientName());
	        status = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return status;
	}

	public int deleteReservation(int id, String name) {
	    int status = 0;
	    String query = "DELETE FROM reservations WHERE id=? AND clientName=?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setInt(1, id);
	        ps.setString(2, name);
	        status = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return status;
	}
}
