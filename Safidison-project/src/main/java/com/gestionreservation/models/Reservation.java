package com.gestionreservation.models;

public class Reservation {
    private int id;
    private String clientName;
    private String reservationDate;
    private String reservationTime;
    
    public Reservation() {
    	
    }
    
    public void setClientName(String clientName) {
    	this.clientName = clientName;
    }
    public void setReservationDate(String reservationDate) {
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
    public String getReservationDate() {
    	return this.reservationDate;
    }
    public String getReservationTime() {
    	return this.reservationTime;
    }
}
