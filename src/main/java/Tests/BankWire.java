package Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PaymentsPage;
import Pages.PlaceOrderPage;
import Pages.ReviewPage;
import Pages.SuperTestNG;

public class BankWire extends SuperTestNG {
	
	@DataProvider
	public Object[][] LoginDetails() {
		
		Object data [][] = new Object [1][2];
		data [0][0] = "108639101";
		data [0][1] = "1234";
		return data;
	} 
	
	LoginPage LP = new LoginPage();
	HomePage HP = new HomePage();
	CartPage CP = new CartPage();
	CheckOutPage CO = new CheckOutPage();
	PaymentsPage PP = new PaymentsPage();
	ReviewPage RP = new ReviewPage();
	PlaceOrderPage PO = new PlaceOrderPage();
	

	
	@Test(dataProvider="LoginDetails")
	public void BankWirePayment(String username, String password) throws InterruptedException, IOException {
		
		childtest = BankWire.createNode("Bank Wire Payment");
		childtest.log(Status.INFO, "<a href=https://shop.unicity.com/#/home>"+"shop live url"+"</a>");
		
		LP.UserLogin(username, password);
		
		HP.home(username);
		HP.all_producst();
		HP.products();
		HP.accessories();
		
		HP.search_product();
		
		HP.all_products_in_list_view();
		HP.products_in_list_view();
		HP.accessories_in_list_view();
		
		CP.product_added_to_cart(username);
		CP.check_the_cart_details();
		
		CP.remove_products_from_cart();
		CP.add_products_to_cart(username);
		CP.check_product();
		CP.check_cart();
		
		CO.cart_go_back();
		CO.check_out(username);
		CO.check_form_fields();
		
		PP.payment_go_back();
		PP.payment_fields(username);
		PP.banks_names();
		PP.order_summary();
		
		RP.review_fields(username);
		RP.shipping_information(username);
		RP.contact_information(username);
		RP.payment_information();
		RP.update_shipping();
		RP.update_contact();
		RP.update_payment();
		RP.go_back();
		RP.review_orders();
		
		PO.placed_order_fields(username);
		PO.placed_shipping_information();
		PO.placed_contact_information();
		PO.placed_payment_information();
		
		PO.placed();
		PO.return_home(username);
		HP.logout();
		
	}
	
}
