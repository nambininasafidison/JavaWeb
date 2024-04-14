package com.gestionreservation.dao;

import com.gestionreservation.models.Utilisateur;
import com.gestionreservation.utils.DatabaseConnection;
import java.sql.*;

public class UtilisateurDao {
    public int enregistrerUtilisateur(Utilisateur utilisateur) {
    	int status = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users (nom, email, motDePasse) VALUES (?, ?, ?)");
            ps.setString(1, utilisateur.getNom());
            ps.setString(2, utilisateur.getEmail());
            ps.setString(3, utilisateur.getMotDePasse());
            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public Utilisateur obtenirUtilisateur(String email, String motDePasse) {
        Utilisateur utilisateur = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND motDePasse = ?;");
            ps.setString(1, email);
            ps.setString(2, motDePasse);
            ResultSet result = ps.executeQuery();
            if(result.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setMotDePasse(result.getString("motDePasse"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }
}
