package com.unical.unitransport.controller.persistence.spedizioniUtente;

public class SpedizioneUtente {
	
	private String email;
	private String tracking_code;
	
	
	public SpedizioneUtente(String tracking_code, String email) {
		super();
		this.email = email;
		this.tracking_code = tracking_code;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTracking_code() {
		return tracking_code;
	}


	public void setTracking_code(String tracking_code) {
		this.tracking_code = tracking_code;
	}


	
	

}
