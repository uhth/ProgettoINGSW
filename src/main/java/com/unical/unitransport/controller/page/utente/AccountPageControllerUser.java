package com.unical.unitransport.controller.page.utente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unical.unitransport.controller.payment.Payment;
import com.unical.unitransport.controller.payment.PaymentDAO;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsSenderReceiverDAO;

@Controller
public class AccountPageControllerUser {

	
	@GetMapping("/profilo_utente")
	public String profilo(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(true);
		List<String> spedizioni = ShipmentsSenderReceiverDAO.getAllString((String)req.getSession().getAttribute("email"));
		session.setAttribute("listaSpedizioni", spedizioni);
		List<Payment> pagamentiOnline = PaymentDAO.getOnlinePayment((String)req.getSession().getAttribute("email"));
		List<Payment> pagamentiContrassegno = PaymentDAO.getOnlinePayment((String)req.getSession().getAttribute("email"));
		if(pagamentiOnline.size()>0) {
			model.addAttribute("listaPagamenti", pagamentiOnline);
			model.addAttribute("sizePagamenti", pagamentiOnline.size()-1);
		}
		/*else if(pagamentiContrassegno.size()>0) {
			model.addAttribute("listaPagamenti", pagamentiContrassegno);
			model.addAttribute("sizePagamenti", pagamentiContrassegno.size()-1);
		}*/
		
		return "profilo_utente_tmp";
	}
	

}
