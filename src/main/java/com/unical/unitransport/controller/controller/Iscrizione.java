package com.unical.unitransport.controller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountsManager;

@Controller
public class Iscrizione {
	

	@PostMapping("/iscrizioneService")
	public String login( HttpServletRequest req, @RequestParam( value = "email", required = true ) String email, @RequestParam( value = "password", required = true ) String password, @RequestParam( value = "password_ripetuta", required = true ) String password_ripetuta ) {
				
		
		Account account = AccountsManager.registerAccount( email, password, "user" );
		if( account == null ) return "iscrizione";
				
		AccountsManager.login( account.getEmail(), account.getPassword() );
		HttpSession session = req.getSession(true);
		
		session.setAttribute( "user_id", account.getUserId() );		
		
		return "iscrizionePositiva";
	}
	 


}