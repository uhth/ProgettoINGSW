package com.unical.unitransport.controller.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountsManager;

@Controller
public class Iscrizione {
	
	
	@GetMapping("/iscrizione")
	public String iscrizionePage() {
		return "iscrizione";
	}
	
	@PostMapping("/iscrizioneService")
	public String login( HttpServletRequest req, @RequestParam( value = "email_new", required = true ) String email, @RequestParam( value = "pass_new", required = true ) String password, @RequestParam( value = "passRipetuta_new", required = true ) String password_ripetuta ) {
				
		
		Account account = AccountsManager.registerAccount( email, password);
		
		System.out.println(email + "---------"+ password);

		if( account == null ) return "loginFallito";
				
		AccountsManager.login( account.getEmail(), account.getPassword() );
		HttpSession session = req.getSession(true);
		
		session.setAttribute( "user_id", account.getUserId() );		
		
		return "iscrizionePositiva";
	}

}
