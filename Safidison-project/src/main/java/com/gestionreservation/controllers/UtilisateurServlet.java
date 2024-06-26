﻿package com.gestionreservation.controllers;

import com.gestionreservation.dao.UtilisateurDao;
import com.gestionreservation.models.Utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/utilisateur")
public class UtilisateurServlet extends HttpServlet {
    private static final long serialVersionUID = -305111940384240084L;
	private UtilisateurDao utilisateurDao;

    public void init() {
        utilisateurDao = new UtilisateurDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("register".equals(action)) {
            String nom = request.getParameter("nom");
            String email = request.getParameter("email");
            String motDePasse = request.getParameter("motDePasse");
            
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(nom);
            utilisateur.setEmail(email);
            utilisateur.setMotDePasse(motDePasse);
            utilisateurDao.enregistrerUtilisateur(utilisateur);
            
            response.sendRedirect("inscription-reussie");
        } else if ("login".equals(action)) {
            String email = request.getParameter("email");
            String motDePasse = request.getParameter("motDePasse");
            
            Utilisateur utilisateur = utilisateurDao.obtenirUtilisateur(email, motDePasse);
            if (utilisateur != null) {
            	HttpSession session = request.getSession();
                session.setAttribute("utilisateurConnecte", utilisateur);
                response.sendRedirect("espace-utilisateur");
            } else {
                request.setAttribute("error", "Identifiants ou mot de passe invalides ou utilisateur non trouvé");
                request.getRequestDispatcher("erreur-connection").forward(request, response);
            }
        }
        else if ("logout".equals(action)) {
        	HttpSession session = request.getSession();
        	session.removeAttribute("utilisateurConnecte");
        	response.sendRedirect("index.jsp");
        }
    }
}
