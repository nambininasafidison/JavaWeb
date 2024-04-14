<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Réservation Confirmée</title>
    <link rel="stylesheet" href="styles/confirmee.css"></link>
    <link rel="stylesheet" href="styles/footer.css"></link>
</head>
	<body>
		<section>
		    <h1>Votre réservation a été confirmée !</h1>
		    <p>Merci, <strong><%= request.getAttribute("nom") %></strong>, pour votre réservation avec <strong><%= request.getAttribute("id") %></strong> comme identifiant.</p>
		    <p>Nous avons bien reçu votre demande pour le <strong><%= request.getAttribute("date") %></strong> à <strong><%= request.getAttribute("heure") %></strong>.</p>
		    <p>Un email de confirmation a été envoyé à <strong><%= request.getAttribute("email") %></strong>.</p>
		    <a href="espace-utilisateur">Retour à l'accueil</a>
		    <a href="utilisateur?action=logout">Deconnexion</a>
		</section>
		<footer>
	        <p>© 2024 Gestion de Réservations chez Gasy. Tous droits réservés.</p>
	    </footer>
	</body>
</html>
