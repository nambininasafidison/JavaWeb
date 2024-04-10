package com.gestionreservation.models;

public class Utilisateur {
    private int id;
    private String nom;
    private String email;
    private String motDePasse;
    
    public Utilisateur () {
    	
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setNom(String nom) {
    	this.nom = nom;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
    public void setMotDePasse(String motDePasse) {
    	this.motDePasse = motDePasse;
    }
    
    public int getId(){
    	return this.id;
    }
    public String getNom() {
    	return this.nom;
    }
    public String getEmail() {
    	return this.email;
    }
    public String getMotDePasse() {
    	return this.motDePasse;
    }
}
