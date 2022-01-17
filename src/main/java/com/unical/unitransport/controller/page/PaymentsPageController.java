package com.unical.unitransport.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentsPageController {
	
	@GetMapping("paymentCard")
	public String pagamento() {
		return "paymentCard";
	}

}
