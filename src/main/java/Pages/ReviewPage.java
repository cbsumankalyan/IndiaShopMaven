package Pages;

import java.io.IOException;
import POM.Home;
import POM.Payment;
import POM.Review;

public class ReviewPage extends SuperTestNG {
	
	
	
	
	
	public void review_fields(String username) throws InterruptedException, IOException{
		Home Home = new Home(driver);
		Review review = new Review(driver);
		Home.CommonMenu(username);
		review.review();
	}
	
	public void retail_review_fields() throws InterruptedException, IOException{
		Review review = new Review(driver);
		review.review();
	}
	
	public void shipping_information(String username) throws IOException{
		Review review = new Review(driver);
		review.shipping(username);
	}
	
	public void retail_shipping_information(){
		Review review = new Review(driver);
		review.retailshipping();
	}
	
	public void contact_information(String username) throws IOException{
		Review review = new Review(driver);
		review.contact(username);
	}
	
	public void retail_contact_information(){
		Review review = new Review(driver);
		review.retailcontact();
	}
	
	public void payment_information(){
		Review review = new Review(driver);
		review.payment();
	}
	
	public void payment_information_ccavenue(){
		Review review = new Review(driver);
		review.ccavenue();
	}
	
	public void review_orders() throws InterruptedException{
		Review review = new Review(driver);
		review.Orders();
	}
	
	public void retail_review_orders() throws InterruptedException{
		Review review = new Review(driver);
		review.RetailOrders();
	}
	
	public void update_shipping() throws InterruptedException{
		Payment payment = new Payment(driver);
		Review review = new Review(driver);
		review.updateshipping();
		payment.paymentfields();
		payment.paymentbanks();
		payment.summary();
		review.updateshippingaddress();
	}
	
	public void retail_update_shipping() throws InterruptedException{
		Payment payment = new Payment(driver);
		Review review = new Review(driver);
		review.updateshipping();
		payment.paymentfields();
		payment.paymentbanks();
		payment.retailsummary();
		review.updateretailshippingaddress();
	}
	
	public void update_contact() throws InterruptedException{
		Payment payment = new Payment(driver);
		Review review = new Review(driver);
		review.updatecontact();
		payment.paymentfields();
		payment.paymentbanks();
		payment.summary();
		review.updatecontactdetails();
	}

	public void retail_update_contact() throws InterruptedException{
		Payment payment = new Payment(driver);
		Review review = new Review(driver);
		review.updatecontact();
		payment.paymentfields();
		payment.paymentbanks();
		payment.retailsummary();
		review.updatecontactdetails();
	}
	
	public void update_payment() throws InterruptedException{
		Payment payment = new Payment(driver);
		Review review = new Review(driver);
		review.updatepayment();
		payment.paymentfields();
		payment.paymentbanks();
		payment.summary();
	}
	
	public void retail_update_payment() throws InterruptedException{
		Payment payment = new Payment(driver);
		Review review = new Review(driver);
		review.updatepayment();
		payment.paymentfields();
		payment.paymentbanks();
		payment.retailsummary();
	}
	
	public void go_back() throws InterruptedException{
		Payment payment = new Payment(driver);
		Review review = new Review(driver);
		review.goback();
		payment.paymentfields();
		payment.paymentbanks();
		payment.summary();
	}
	
	public void retail_go_back() throws InterruptedException{
		Payment payment = new Payment(driver);
		Review review = new Review(driver);
		review.goback();
		payment.paymentfields();
		payment.paymentbanks();
		payment.retailsummary();
	}

}
