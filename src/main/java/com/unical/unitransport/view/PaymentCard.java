package com.unical.unitransport.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentCard {
	
	@GetMapping("paymentCard")
	public String pagamento() {
		return "paymentCard";
	}

}
