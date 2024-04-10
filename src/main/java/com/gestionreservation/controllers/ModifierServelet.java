package com.gestionreservation.controllers;

import java.io.IOException;

import com.gestionreservation.dao.ReservationDao;
import com.gestionreservation.models.Reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modifier")
public class ModifierServelet extends jakarta.servlet.http.HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/reservation-modifier.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }
}