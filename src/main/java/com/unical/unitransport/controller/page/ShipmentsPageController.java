package com.unical.unitransport.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShipmentsPageController {
	
	@GetMapping("/spedisci")
	public String spedisci() {
		return "effettua_spedizione";
	}

}
