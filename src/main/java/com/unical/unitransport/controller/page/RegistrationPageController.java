package com.unical.unitransport.controller.page;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountRole;
import com.unical.unitransport.controller.persistence.account.AccountRoleDAO;
import com.unical.unitransport.controller.persistence.account.AccountsManager;

@Controller
public class RegistrationPageController {
	

	@PostMapping("/iscrizioneService")
	public String login( HttpServletResponse res,
			HttpServletRequest req,
			@RequestParam( value = "email", required = true ) String email,
			@RequestParam( value = "password", required = true ) String password,
			@RequestParam( value = "password_ripetuta", required = true ) String password_ripetuta ) throws IOException {
		
		
		int diff = password.compareTo( password_ripetuta );
		if( diff != 0 ) {
			System.out.println( password + " " + password_ripetuta );
			res.sendError( HttpServletResponse.SC_BAD_REQUEST );
		}
		
		Account account = AccountsManager.registerAccount( email, password );
		if( account == null ) return "iscrizione";
				
		AccountsManager.login( account.getEmail(), account.getPassword() );
		HttpSession session = req.getSession(true);
		
		session.setAttribute( "user_id", account.getUserId() );		
		
		AccountRole ruolo = new AccountRole(account.getUserId(), 0);
		AccountRoleDAO.insert(ruolo);
		
		System.out.println(account.getUserId());
		
		return "iscrizionePositiva";
	}
	 


}