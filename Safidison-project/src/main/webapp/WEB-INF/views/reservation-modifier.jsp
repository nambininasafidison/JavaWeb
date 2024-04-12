<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Réservation</title>
</head>
<body>
    <h2>Modifier votre réservation</h2>
    <form action="reservation?action=update" method="post">
        ID de réservation: <input type="text" name="id">
        Nom du client: <input type="text" name="clientName">
        Date de réservation: <input type="text" name="reservationDate">
        Heure de réservation: <input type="text" name="reservationTime">
        <input type="submit" value="Mettre à jour">
    </form>
</body>
</html>
