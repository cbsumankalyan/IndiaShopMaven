package Pages;

import java.io.IOException;

import POM.Cart;
import POM.CheckOut;
import POM.Home;

public class CheckOutPage extends SuperTestNG {
	
	
	
	
	

	public void cart_go_back() throws IOException, InterruptedException{
		Cart Cart = new Cart(driver);
		CheckOut checkout = new CheckOut(driver);
		checkout.GoBack();
		Cart.checkcart();
	}
	
	public void check_out(String username) throws InterruptedException, IOException{
		Home Home = new Home(driver);
		CheckOut checkout = new CheckOut(driver);
		Home.CommonMenu(username);
		checkout.checkout();
	}
	
	public void check_form_fields(){
		CheckOut checkout = new CheckOut(driver);
		checkout.formdetails();
	}
	
	public void check_retail_form_fields(){
		CheckOut checkout = new CheckOut(driver);
		checkout.retailformdetails();
	}
}
