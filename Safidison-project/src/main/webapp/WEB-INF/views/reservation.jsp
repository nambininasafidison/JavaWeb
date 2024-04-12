<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Formulaire de Réservation</title>
</head>
<body>
    <form action="ReservationServlet" method="post">
        Nom: <input type="text" name="nom" />
        Date: <input type="text" name="date" />
        Heure: <input type="text" name="heure" />
        <input type="submit" value="Réserver" />
    </form>
</body>
</html>
