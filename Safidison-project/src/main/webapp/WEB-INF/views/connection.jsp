<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
    <form action="utilisateur?action=login" method="post">
        Email: <input type="email" name="email">
        Mot de passe: <input type="password" name="motDePasse">
        <input type="submit" value="Se connecter">
    </form>
</body>
</html>