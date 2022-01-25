package com.unical.unitransport.controller.page.utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unical.unitransport.controller.persistence.account.Account;
import com.unical.unitransport.controller.persistence.account.AccountsDAO;
import com.unical.unitransport.controller.persistence.account.AccountsManager;

@Controller
public class CambioPassword {
	
	
	@GetMapping("/cambiaPassword")
	public String cambioPassword(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("passwordInseritaValida", null);
		return "modifica_password";
	}
	
	@PostMapping("cambioPassword")
	public String inserisciVecchiaPassword(HttpServletRequest req, HttpServletResponse res,
						@RequestParam( value = "richiediCambioPassword", required = true ) String password ) {
		
		HttpSession session = req.getSession();
		
		if (AccountsManager.login((String) session.getAttribute("email"), password)) {
			session.setAttribute("passwordInseritaValida", "true");
		} else {
			session.setAttribute("erroreGenerico", "LA PASSWORD NON É CORRETTA");
			session.setAttribute("erroreGenerico_p", "Riprova facendo attenzione anche ai caratteri in maiuscolo");
			return "erroreGenerico";
		}
		
		return "modifica_password";
	}
	
	@PostMapping("cambioPasswordNuova")
	public String inserisciNuovaPassword(HttpServletRequest req, HttpServletResponse res,
			@RequestParam( value = "passwordNuova", required = true ) String password,
			@RequestParam( value = "passwordNuovaRipeti", required = true ) String passwordRipetuta) {
		
		HttpSession session = req.getSession();
		
		if (password.equals(passwordRipetuta)) {
			session.setAttribute("passwordInseritaValida", null);
			Account account = AccountsDAO.getByEmail((String) session.getAttribute("email"));
			AccountsDAO.updatePassword(account, password);
			session.setAttribute("validoGenerico", "LA PASSWORD É STATA MODIFICATA CORRETTAMENTE");
			session.setAttribute("validoGenerico_p", "Ricorda di conservarla in un posto sicuro");
			return "validoGenerico";
		} else {
			session.setAttribute("erroreGenerico", "LE PASSWORD NON COINCIDONO");
			session.setAttribute("erroreGenerico_p", "Riprova facendo attenzione anche ai caratteri in maiuscolo");
			return "erroreGenerico";
		

		}

	}

}
