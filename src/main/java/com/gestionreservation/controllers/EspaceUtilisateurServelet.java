package com.gestionreservation.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/espace-utilisateur")
public class EspaceUtilisateurServelet extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/espace-utilisateur.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }
}