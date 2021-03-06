package com.unical.unitransport.controller.page;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountsManager;

@Controller
public class RegistrationPageController {
	
	@PostMapping("/iscrizioneCorriereService")
	public String registerCorriere(	HttpServletResponse res,	
		HttpServletRequest req,
		@RequestParam( value = "email", required = true ) String email,
		@RequestParam( value = "password", required = true ) String password,
		@RequestParam( value = "password_ripetuta", required = true ) String password_ripetuta ) throws IOException {

		HttpSession session = req.getSession(true);

	int diff = password.compareTo( password_ripetuta );
	if( diff != 0 ) {
		res.sendError( HttpServletResponse.SC_BAD_REQUEST );
	}
	
	Account account = AccountsManager.registerAccount( email, password, "corriere" );
	if( account == null ){
		session.setAttribute("erroreGenerico", "Si è verificato qualche errore");
		session.setAttribute("erroreGenerico_p", null);
		return "erroreGenerico";
			}
					
	return "iscrizionePositiva";
}

	@PostMapping("/iscrizioneService")
	public String registerUser( HttpServletResponse res,
			HttpServletRequest req,
			@RequestParam( value = "email", required = true ) String email,
			@RequestParam( value = "password", required = true ) String password,
			@RequestParam( value = "password_ripetuta", required = true ) String password_ripetuta ) throws IOException {
		
		HttpSession session = req.getSession(true);
		
		int diff = password.compareTo( password_ripetuta );
		if( diff != 0 ) {
			res.sendError( HttpServletResponse.SC_BAD_REQUEST );
		}
		
		Account account = AccountsManager.registerAccount( email, password, "user" );
		if( account == null ){
			session.setAttribute("erroreGenerico", "SI E' VERIFICATO UN ERRORE");
			session.setAttribute("erroreGenerico_p", "");
			return "erroreGenerico";
		}
				
		AccountsManager.login( account.getEmail(), account.getPassword() );
		
		session.setAttribute( "user_id", account.getUserId() );		
		
		
		return "iscrizionePositiva";
	}
	 


}