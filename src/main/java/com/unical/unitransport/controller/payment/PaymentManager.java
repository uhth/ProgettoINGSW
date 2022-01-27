package com.unical.unitransport.controller.payment;

import com.unical.unitransport.controller.persistence.shipment.Shipment;

public interface PaymentManager {
	public static Payment registerPayment(Shipment shipment, int type, float amount) {
		Payment pay = new Payment(type, amount);
		if(!PaymentDAO.insert(pay)) return null;
		
		return null;
	}
}
