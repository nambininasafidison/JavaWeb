<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inscription</title>
  	<link rel="stylesheet" href="styles/inscription.css"></link>
  	<link rel="stylesheet" href="styles/input.css"></link>
  	<link rel="stylesheet" href="styles/footer.css"></link>
</head>
<body>
	<a href="index.jsp">Accueil</a>
    <form action="utilisateur?action=register" method="post">
    	<div class="input">
    		<label>Nom:</label>
	         <input type="text" name="nom" required>
    	</div>
    	<div class="input">
    		<label>Email:</label>
	         <input type="email" name="email" required>
    	</div>
    	<div class="input">
    		<label>Mot de passe:</label>
	         <input type="password" name="motDePasse" required>
    	</div>
        <input class="submit" type="submit" value="S'inscrire">
    </form>
    <footer>
        <p>© 2024 Gestion de Réservations chez Gasy. Tous droits réservés.</p>
    </footer>
</body>
</html>
