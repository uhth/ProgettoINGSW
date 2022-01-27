package com.unical.unitransport.controller.page.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountsDAO;
import com.unical.unitransport.controller.persistence.account.AccountsManager;
import com.unical.unitransport.controller.persistence.account.Role;


@Controller
public class AggiungiRimuoviCorriere {
	
	@GetMapping("/aggiungiCorriere")
	public String aggiungiCorrieri(	Model model,
									HttpServletRequest req,
									HttpServletResponse res ) {
		
		//L'admin è loggato?
		if( !AccountsManager.isLoggedIn( req ) ) {
			res.setStatus( HttpServletResponse.SC_UNAUTHORIZED );
			return "/";
		}
		
		//Aggiungo gli utenti alla lista
		List<Account> lista = AccountsDAO.getAll();
		List<String> listaUtenti = new ArrayList<String>();
		for( Account account : lista ) {
			Role role = AccountsManager.getUserRole( account );
			if( role != null && role.getRoleName().compareTo( "user" ) == 0 ) {
				listaUtenti.add( "\"" + account.getEmail() + "\"" );
			}
		}
		
		//Aggiungo la lista al model
		model.addAttribute( "listaUtentiConvertibili", listaUtenti );

		return "aggiungi_corriere";
	}
	
	
	@PostMapping("/aggiuntaCorriere")
	public void aggiungiCorriere(	HttpServletRequest req,
								   	HttpServletResponse res,
								   	@RequestParam( value = "email", required = true ) String email ) {
		
		AccountsManager.changeAccountRole( email, "corriere");
		res.setStatus( HttpServletResponse.SC_ACCEPTED );
}
	
	
	@GetMapping("/rimuoviCorriere")
	public String rimuoviCorrieri(	Model model,
									HttpServletRequest req,
									HttpServletResponse res ) {

		//L'admin è loggato?
		if( !AccountsManager.isLoggedIn( req ) ) {
		res.setStatus( HttpServletResponse.SC_UNAUTHORIZED );
		return "/";
		}
		
		//Aggiungo gli utenti alla lista
		List<Account> lista = AccountsDAO.getAll();
		List<String> listaUtenti = new ArrayList<String>();
		for( Account account : lista ) {
		Role role = AccountsManager.getUserRole( account );
			if( role != null && role.getRoleName().compareTo( "corriere" ) == 0 ) {
			listaUtenti.add( "\"" + account.getEmail() + "\"" );
			}
		}
		
		//Aggiungo la lista al model
		model.addAttribute( "listaUtentiConvertibili", listaUtenti );

		return "rimuovi_corriere";
	}
	
	
		@PostMapping("/rimozioneCorriere")
		public void rimuoviCorriere(	HttpServletRequest req,
									   	HttpServletResponse res,
									   	@RequestParam( value = "email", required = true ) String email ) {
			
			AccountsManager.changeAccountRole( email, "user");
			res.setStatus( HttpServletResponse.SC_ACCEPTED );
	}
	

}


