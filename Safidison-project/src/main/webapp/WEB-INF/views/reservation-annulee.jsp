<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Réservation Confirmée</title>
    <link rel="stylesheet" href="styles/annulee.css"></link>
    <link rel="stylesheet" href="styles/footer.css"></link>
</head>
	<body>
		<section>
		    <h1>Votre réservation a été annulée !</h1>
		    <p>La réservation qui porte l'identifiant <strong><%= request.getAttribute("id") %></strong> de Mme/Mr <strong><%= request.getAttribute("nom") %></strong> a été annulée avec succes</p>
		    <a href="espace-utilisateur">Retour à l'accueil</a>
		    <a href="utilisateur?action=logout">Deconnexion</a>
		</section>
		<footer>
	        <p>© 2024 Gestion de Réservations chez Gasy. Tous droits réservés.</p>
	    </footer>
	</body>
</html>
