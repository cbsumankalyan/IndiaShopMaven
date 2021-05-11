package Pages;

import java.io.IOException;
import POM.CheckOut;
import POM.Home;
import POM.Payment;


public class PaymentsPage extends SuperTestNG {

	
	
	
	
	public void payment_go_back() throws InterruptedException{
		Payment payment = new Payment(driver);
		CheckOut checkout = new CheckOut(driver);
		payment.GoBack();
		checkout.checkout();
		checkout.formdetails();
	}
	
	public void payment_fields(String username) throws InterruptedException, IOException{
		Home Home = new Home(driver);
		Payment payment = new Payment(driver);
		Home.CommonMenu(username);
		payment.paymentfields();
	}
	
	public void payment_fields() throws InterruptedException, IOException{
		Payment payment = new Payment(driver);
		payment.paymentfields();
	}
	
	public void banks_names() throws InterruptedException{
		Payment payment = new Payment(driver);
		payment.paymentbanks();
	}
	
	public void order_summary() throws InterruptedException{
		Payment payment = new Payment(driver);
		payment.summary();
	}
	
	public void retail_order_summary() throws InterruptedException{
		Payment payment = new Payment(driver);
		payment.retailsummary();
	}
	
	public void payment_essecom() throws InterruptedException, IOException{
		Payment payment = new Payment(driver);
		payment.Essecom();
	}
	
	public void payment_avenue() throws InterruptedException{
		Payment payment = new Payment(driver);
		payment.CCAvenue();
	}
}
