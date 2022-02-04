package com.unical.unitransport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.unical.unitransport.controller.payment.Payment;
import com.unical.unitransport.controller.payment.PaymentDAO;

@SpringBootTest
public class PaymentTest {
	@BeforeAll
	public static void resetPayment() {
		PaymentDAO.removeAll();
	}
	
	@Test
	@DisplayName("test payment")
	void paymentTest() {
		Date data = new Date();
		//assertEquals(true, PaymentDAO.insert(new Payment(0 , (float) 999.99 , new Timestamp(data.getTime()) , "topierpytube2@live.it")));
	}
}
