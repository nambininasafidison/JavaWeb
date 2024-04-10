package com.gestionreservation.controllers;

import com.gestionreservation.dao.ReservationDao;
import com.gestionreservation.models.Reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    private ReservationDao reservationDao;

    public void init() {
        reservationDao = new ReservationDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Récupération des données du formulaire
        String clientName = request.getParameter("clientName");
        String reservationDate = request.getParameter("reservationDate");
        String reservationTime = request.getParameter("reservationTime");

        // Création de l'objet Reservation
        Reservation reservation = new Reservation();
        reservation.setClientName(clientName);
        reservation.setReservationDate(reservationDate);
        reservation.setReservationTime(reservationTime);

        // Enregistrement de la réservation via ReservationDao
        reservationDao.saveReservation(reservation);

        // Redirection vers une page de confirmation
        response.sendRedirect("confirmee");
    }
}
