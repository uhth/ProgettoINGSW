package com.unical.unitransport.controller.page;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountsDAO;
import com.unical.unitransport.controller.persistence.account.AccountsManager;
import com.unical.unitransport.controller.persistence.account.Role;
import com.unical.unitransport.controller.persistence.account.RolesDAO;

@Controller
public class LoginPageController {
	
	@GetMapping("/login")
	public String loginPage( HttpServletRequest req ) {
		if( req.isRequestedSessionIdValid() ) {
			if( req.getAttribute( "email " ) != null )
				return "index";
		}
		return "login";
	}
	
	@GetMapping("/iscrizione")
	public String iscrizionePage() {
		return "iscrizione";
	}
	
	@GetMapping("/logout")
	public void logout (HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession(false);
		if( session != null ) {
			session.invalidate();
		}
		res.sendRedirect("/");
	}
	
	@PostMapping("/loginService")
	public String login(
			Model model,
			HttpServletRequest req,
			HttpServletResponse res,
			@RequestParam( value = "email", required = true ) String email,
			@RequestParam( value = "password", required = true ) String password ) {
		
		HttpSession session;
		
		if( AccountsManager.login( email, password ) ) { 
			session = req.getSession(false);
			if( session != null ) session.invalidate();
		}
		
		else return "loginFallito";
		
		session = req.getSession( true );
		session.setAttribute( "email", email );
		
		Account account = AccountsDAO.getByEmail( email );
		Role role = AccountsManager.getUserRole( account );
		if( role == null ) role = RolesDAO.getByName( "user" );
		session.setAttribute( "role" , role.getRoleName() );
		
		return "index";
		
	}
	
	
	

}
