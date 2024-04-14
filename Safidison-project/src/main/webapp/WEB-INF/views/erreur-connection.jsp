<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Erreur de Réservation</title>
    <link rel="stylesheet" href="styles/erreur.css"></link>
    <link rel="stylesheet" href="styles/footer.css"></link>
</head>
<body>
	<section>
	    <h1>Erreur lors de la connection</h1>
	    <p><%= request.getAttribute("error") %>.</p>
	    <div>
		    <a href="connetion">Retour au formulaire de connection</a>
		    <a href="inscription">S'inscrire</a>
	    </div>
	</section>
	<footer>
        <p>© 2024 Gestion de Réservations chez Gasy. Tous droits réservés.</p>
    </footer>
</body>
</html>
