﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Formulaire de Réservation</title>
    <link rel="stylesheet" href="styles/reservation.css"></link>
    <link rel="stylesheet" href="styles/input.css"></link>
    <link rel="stylesheet" href="styles/logout.css"></link>
    <link rel="stylesheet" href="styles/footer.css"></link>
</head>
<body>
	<h2>Réserver une table</h2>
    <form action="reservation?action=reserve" method="post">
    	<div class="input">
    		<label>Nom:</label>
	         <input type="text" name="clientName" required/>
    	</div>
    	<div class="input">
    		<label>Date:</label>
	         <input type="date" name="reservationDate" required />
    	</div>
    	<div class="input">
    		<label>Heure:</label>
	        <input type="time" name="reservationTime" required />
    	</div>
        <input class="submit" type="submit" value="Réserver" />
    </form>
    <a href="utilisateur?action=logout">Deconnexion</a>
    <footer>
        <p>© 2024 Gestion de Réservations chez Gasy. Tous droits réservés.</p>
    </footer>
</body>
</html>
