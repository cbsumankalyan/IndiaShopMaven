package Pages;

import POM.Essecom;

public class EssecomPage extends SuperTestNG {
	
	
	
	public void essecom_payment_details() throws InterruptedException{
		Essecom payment = new Essecom(driver);
		payment.payment();
	}

}
