<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
    <form action="utilisateur?action=register" method="post">
        Nom: <input type="text" name="nom">
        Email: <input type="email" name="email">
        Mot de passe: <input type="password" name="motDePasse">
        <input type="submit" value="S'inscrire">
    </form>
</body>
</html>
