package com.gestionreservation.controllers;

import java.io.IOException;

import com.gestionreservation.models.Utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modifiee")
public class ModifieeServelet extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/reservation-modifiee.jsp";
        Utilisateur utilisateurConnecte = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
        if (utilisateurConnecte != null) {
        	request.getRequestDispatcher(path).forward(request, response);
        } else {
        	response.sendRedirect("connexion");
        }
    }
}
