package com.gestionreservation.dao;

import com.gestionreservation.models.Utilisateur;
import com.gestionreservation.utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;

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
    
    public Utilisateur obtenirUtilisateur(String email,String motDePasse) {
    	 Utilisateur user = new Utilisateur();
    	 ArrayList <Utilisateur> utilisateurs = new ArrayList<>();
         try {
             Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM users;");
             ResultSet result = ps.executeQuery();
             while(result.next()) {
             	Utilisateur utilisateur = new Utilisateur();
             	utilisateur.setEmail(result.getString("nom"));
             	utilisateur.setMotDePasse(result.getString("motDePasse"));
             	utilisateurs.add(utilisateur);
             }
             conn.close();
             for(Utilisateur u:utilisateurs) {
            	 if(u.getEmail().equals(email) && u.getMotDePasse().equals(motDePasse)) {
            		 user = u;
            	 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return user;
    }
}
