<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Annuler Réservation</title>
</head>
<body>
    <h2>Annuler une réservation</h2>
    <form action="reservation?action=delete" method="post">
        ID de réservation: <input type="text" name="id">
        <input type="submit" value="Annuler">
    </form>
</body>
</html>
