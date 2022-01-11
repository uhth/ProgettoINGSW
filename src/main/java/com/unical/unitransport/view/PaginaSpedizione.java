package com.unical.unitransport.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaSpedizione {
	
	@GetMapping("spedisci")
	public String spedisci() {
		return "effettua_spedizione";
	}

}
