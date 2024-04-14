package com.gestionreservation.models;

public class Reservation {
    private int id;
    private String clientName;
    private java.sql.Date reservationDate;
    private String reservationTime;
    
    public Reservation() {
    	
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setClientName(String clientName) {
    	this.clientName = clientName;
    }
    public void setReservationDate(java.sql.Date reservationDate) {
    	this.reservationDate = reservationDate;
    }
    public void setReservationTime(String reservationTime) {
    	this.reservationTime = reservationTime;
    }
    
    public int getId(){
    	return this.id;
    }
    public String getClientName() {
    	return this.clientName;
    }
    public java.sql.Date getReservationDate() {
    	return this.reservationDate;
    }
    public String getReservationTime() {
    	return this.reservationTime;
    }
}
