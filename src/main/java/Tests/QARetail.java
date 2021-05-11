package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.PaymentsPage;
import Pages.PlaceOrderPage;
import Pages.ReviewPage;
import Pages.SuperTestNG;

public class QARetail extends SuperTestNG {
	
	HomePage HP = new HomePage();
	CartPage CP = new CartPage();
	CheckOutPage CO = new CheckOutPage();
	PaymentsPage PP = new PaymentsPage();
	ReviewPage RP = new ReviewPage();
	PlaceOrderPage PO = new PlaceOrderPage();
	
	@Test()
	public void RetailOrder() throws InterruptedException, IOException {
		
		childtest = QARetail.createNode("Retail Customer");
		childtest.log(Status.INFO, "<a href=https://shop.unicityqa.com/master/#/home>"+"shop qa url"+"</a>");
		
		HP.select_state();
		HP.retail_home_page();
		
		CP.added_retail_product_to_cart();
		CP.check_the_retail_cart_details();
		
		CP.remove_retail_products_from_cart();
		CP.add_retail_products_to_cart();
		CP.check_retail_product();
		CP.check_retail_cart();
		
		CP.sign_up_retail_customer();
		
		CO.check_retail_form_fields();
		
		PP.payment_fields();
		PP.banks_names();
		PP.retail_order_summary();
		
		RP.retail_review_fields();
		RP.retail_shipping_information();
		RP.retail_contact_information();
		RP.payment_information();
		
		RP.retail_update_shipping();
		RP.retail_update_contact();
		RP.retail_update_payment();
		
		RP.retail_go_back();
		RP.retail_review_orders();
		
		PO.retail_placed_order_fields();
		PO.placed_retail_shipping_information();
		PO.placed_contact_information();
		PO.placed_payment_information();
		
		PO.retail_placed();
		PO.retail_return_home();
		
		HP.logout();
	}

}
