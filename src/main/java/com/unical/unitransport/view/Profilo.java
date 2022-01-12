package com.unical.unitransport.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Profilo {
	
	@GetMapping("profilo_utente")
	public String profilo() {
		return "profilo_utente";
	}

}
