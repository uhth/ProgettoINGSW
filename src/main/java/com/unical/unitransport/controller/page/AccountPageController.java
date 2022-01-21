package com.unical.unitransport.controller.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;
import com.unical.unitransport.controller.persistence.spedizioniCorriere.SpedizioneCorriere;
import com.unical.unitransport.controller.persistence.spedizioniCorriere.SpedizioneCorriereDAO;
import com.unical.unitransport.controller.persistence.spedizioniUtente.SpedizioneUtenteDAO;

@Controller
public class AccountPageController {
	
	@GetMapping("/profilo_utente")
	public String profilo(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		List<String> spedizioni = SpedizioneUtenteDAO.getAllString((String)req.getSession().getAttribute("email"));
		session.setAttribute("listaSpedizioni", spedizioni);
		
		return "profilo_utente_tmp";
	}
	
	
	@GetMapping("/areaCorriere")
	public String areaCorriere(HttpServletRequest req) {
		
		HttpSession session = req.getSession(true);
		List<String> spedizioniTotali = SpedizioneCorriereDAO.getAllDisponibiliString();
		session.setAttribute("listaSpedizioniTotale", spedizioniTotali);
		List<String> spedizioniCorriere = SpedizioneCorriereDAO.getAllSpedizioniCorriere((String)req.getSession().getAttribute("email"));
		session.setAttribute("listaSpedizioni", spedizioniCorriere);

		return "area_corriere";
	}
	
	@PostMapping("richiestaCorriere")
	public String richiestaConsegna(HttpServletRequest req, HttpServletResponse res, String richiestaSpedizione) throws IOException {
		HttpSession session = req.getSession(true);
		
		if (ShipmentsDAO.getByTrackingNumber(richiestaSpedizione)!=null) {
			SpedizioneCorriere richiesta = new SpedizioneCorriere(richiestaSpedizione, (String) session.getAttribute("email"));
			if (!SpedizioneCorriereDAO.spedizioneGiaAssegnata(richiestaSpedizione)) {
				SpedizioneCorriereDAO.insert(richiesta);
				res.sendRedirect("/areaCorriere");
				} else { 
					session.setAttribute("erroreGenerico", "HAI GIÀ PRESO IN CARICO QUESTA SPEDIZIONE");
					return "erroreGenerico";
				}
					
		}
		
		session.setAttribute("erroreGenerico", "LA SPEDIZIONE NON ESISTE");
		return "erroreGenerico";
	}
	

}

//<form  method="post" action="richiestaCorriere">
//<div class="form-group">
//  <label for="formLuogo"></label>
//  <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="es. un1tr4$p0rT" name="richiestaSpedizione">