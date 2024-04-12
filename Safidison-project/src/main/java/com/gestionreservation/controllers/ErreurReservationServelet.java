package com.gestionreservation.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/erreur-reservation")
public class ErreurReservationServelet extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/erreur-reservation.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }
}