package com.unical.unitransport.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaSpedizione {
	
	@GetMapping("spedisci")
	public String spedisci() {
		return "effettua_spedizione";
	}
	
	@GetMapping("spedizione_tracciabile")
	public String spedizioneTracciabile() {
		return "effettua_spedizione_tracciabile";
	}
	
	@GetMapping("spedizione_express")
	public String spedizioneExpress() {
		return "effettua_spedizione_express";
	}
	
	@GetMapping("spedizione_assicurata")
	public String spedizioneAssicurata() {
		return "effettua_spedizione_assicurata";
	}

}
