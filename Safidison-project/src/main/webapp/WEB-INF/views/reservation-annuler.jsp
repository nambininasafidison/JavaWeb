﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Annuler Réservation</title>
    <link rel="stylesheet" href="styles/annuler.css"></link>
    <link rel="stylesheet" href="styles/input.css"></link>
    <link rel="stylesheet" href="styles/logout.css"></link>
    <link rel="stylesheet" href="styles/footer.css"></link>
</head>
<body>
    <h2>Annuler une réservation</h2>
    <form action="reservation?action=delete" method="post">
    	<div class="input">
    		<label>ID de réservation:</label>
	         <input type="text" name="id" required>
    	</div>
    	<div class="input">
    		<label>Nom:</label>
	         <input type="text" name="clientName" required>
    	</div>
        <input class="submit" type="submit" value="Annuler">
    </form>
    <a href="utilisateur?action=logout">Deconnexion</a>
    <footer>
        <p>© 2024 Gestion de Réservations chez Gasy. Tous droits réservés.</p>
    </footer>
</body>
</html>
