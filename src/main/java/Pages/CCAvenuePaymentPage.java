package Pages;

import POM.CCAvenue;
import POM.Review;

public class CCAvenuePaymentPage extends SuperTestNG {

	public void ccavenue_payment_details() throws InterruptedException{
		
		CCAvenue payment = new CCAvenue(driver);
		Review review = new Review(driver);
		
		review.Orders();
		payment.ccavenue();
	}

}
