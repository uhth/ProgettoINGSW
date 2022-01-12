package com.unical.unitransport.controller.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unical.unitransport.controller.persistence.account.AccountsManager;

@Controller
public class Iscrizione {
	
	
	@GetMapping("/iscrizione")
	public String iscrizionePage() {
		return "iscrizione";
	}
	
	@PostMapping("/iscrizioneService")
	public String login(HttpServletRequest req, HttpServletResponse res, String username_new, String pass_new) throws IOException{
		
		
		
	//	HttpSession session = req.getSession(true);
		
		if (AccountsManager.registerAccount(username_new, pass_new, "1"))
			return "iscrizionePositiva";
		
		return "index";
		
	}
	 

}
