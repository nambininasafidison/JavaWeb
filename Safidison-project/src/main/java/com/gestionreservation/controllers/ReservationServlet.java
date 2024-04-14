package com.gestionreservation.controllers;

import com.gestionreservation.dao.ReservationDao;
import com.gestionreservation.models.Reservation;
import com.gestionreservation.models.Utilisateur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationDao reservationDao;

    public void init() {
        reservationDao = new ReservationDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
    	String clientName = request.getParameter("clientName");
        String reservationDate = request.getParameter("reservationDate");
        String reservationTime = request.getParameter("reservationTime");
        String action = request.getParameter("action");
        Utilisateur utilisateurConnecte = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
        if(utilisateurConnecte != null) {
	    	if("reserve".equals(action)) {
	    		String clientEmail = utilisateurConnecte.getEmail();
	    		
	    		SimpleDateFormat originalDate = new SimpleDateFormat("yyyy-MM-dd");
	    		java.util.Date date = null;
	    		try {
	    			date = originalDate.parse(reservationDate);
	    		} catch (ParseException e) {
	    			e.printStackTrace();
	    		}
	    		
	    		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    		
	    		Reservation reservation = new Reservation();
	    		reservation.setClientName(clientName);
	    		reservation.setReservationDate(sqlDate);
	    		reservation.setReservationTime(reservationTime);
	    		
	    		reservationDao.saveReservation(reservation);
	    		
	    		request.setAttribute("id", reservation.getId());
	    		request.setAttribute("nom", clientName);
	    		request.setAttribute("date", sqlDate);
	    		request.setAttribute("heure", reservationTime);
	    		request.setAttribute("email", clientEmail); 
	    		
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("confirmee");
	    		dispatcher.forward(request, response);
	    	} else if("update".equals(action)) {
	    		String clientEmail = utilisateurConnecte.getEmail();
	    		int id;
	    	    try {
	    	        id = Integer.parseInt(request.getParameter("id"));
	    	    } catch (NumberFormatException e) {
	    	        e.printStackTrace();
	    	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid reservation ID");
	    	        return;
	    	    }
	    		
	    	    SimpleDateFormat originalDate = new SimpleDateFormat("yyyy-MM-dd");
	    		java.util.Date date = null;
	    		try {
	    			date = originalDate.parse(reservationDate);
	    		} catch (ParseException e) {
	    			e.printStackTrace();
	    		}
	    		
	    		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    		
	    		Reservation reservation = new Reservation();
	    		reservation.setId(id);
	    		reservation.setClientName(clientName);
	    		reservation.setReservationDate(sqlDate);
	    		reservation.setReservationTime(reservationTime);
	    		
	    		int res = reservationDao.updateReservation(reservation);
	    		if (res > 0) {
		    		request.setAttribute("id", id);
		    		request.setAttribute("nom", clientName);
		    		request.setAttribute("date", sqlDate);
		    		request.setAttribute("heure", reservationTime);
		    		request.setAttribute("email", clientEmail); 
		    		
		    		RequestDispatcher dispatcher = request.getRequestDispatcher("modifiee");
		    		dispatcher.forward(request, response);
		    	}
				else {
					request.setAttribute("error", "L'identifiant et le nom de la reservation que vous essayez de modifier ne sont pas compatible ou la reservation n'existe pas");
					RequestDispatcher dispatcher = request.getRequestDispatcher("erreur-reservation");
					dispatcher.forward(request, response);
				}
	    	} else if("delete".equals(action)) {
	    		int id;
	    	    try {
	    	        id = Integer.parseInt(request.getParameter("id"));
	    	    } catch (NumberFormatException e) {
	    	        e.printStackTrace();
	    	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid reservation ID");
	    	        return;
	    	    }
	    		int res = reservationDao.deleteReservation(id, clientName);
	    		if (res > 0) {
	    			request.setAttribute("id", id);
	    			request.setAttribute("nom", clientName);
	    			RequestDispatcher dispatcher = request.getRequestDispatcher("annulee");
	    			dispatcher.forward(request, response);
	    		}
	    		else {
	    			request.setAttribute("error", "L'identifiant et le nom de la reservation que vous essayez d'annuler ne sont pas compatible ou la reservation n'existe pas");
	    			RequestDispatcher dispatcher = request.getRequestDispatcher("erreur-reservation");
	    			dispatcher.forward(request, response);
	    		}
	    		
	    	}
        } else {
        	response.sendRedirect("connexion");
        }
	}
}
