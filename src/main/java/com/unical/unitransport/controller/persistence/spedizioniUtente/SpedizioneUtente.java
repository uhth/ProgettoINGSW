package com.unical.unitransport.controller.persistence.spedizioniUtente;

public class SpedizioneUtente {
	
	private String email;
	private String tracking_code;
	private String luogo_ritiro;
	
	
	public SpedizioneUtente(String tracking_code, String email, String luogo_ritiro) {
		super();
		this.email = email;
		this.tracking_code = tracking_code;
		this.luogo_ritiro=luogo_ritiro;
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


	public String getLuogo_ritiro() {
		return luogo_ritiro;
	}


	public void setLuogo_ritiro(String luogo_ritiro) {
		this.luogo_ritiro = luogo_ritiro;
	}

	
	

}
