package Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.EssecomPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PaymentsPage;
import Pages.ReviewPage;
import Pages.SuperTestNG;

public class Essecom extends SuperTestNG {
	
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
	EssecomPage EP = new EssecomPage();
	
	@Test(dataProvider="LoginDetails")
	public void EssecomPayment(String username, String password) throws InterruptedException, IOException {
		
		childtest = Essecom.createNode("<b><font color=green>Essecom  Payment</font></b>");
		childtest.log(Status.INFO, "<a href=https://shop.unicity.com/#/home>"+"shop live url"+"</a>");
		
		LP.UserLogin(username, password);
		HP.home(username);
		CP.add_products_to_cart(username);
		CP.check_product();
		CP.check_cart();
		CO.check_form_fields();
		PP.payment_essecom();
	}

}
