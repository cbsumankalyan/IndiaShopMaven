package Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CCAvenuePaymentPage;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PaymentsPage;
import Pages.SuperTestNG;

public class QACCAvenue extends SuperTestNG {
	
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
	CCAvenuePaymentPage CCA = new CCAvenuePaymentPage();
	
	@Test(dataProvider="LoginDetails")
	public void CCAvenuePayment(String username, String password) throws InterruptedException, IOException {
		
		childtest = QACCAvenue.createNode("<b><font color=green>Kotak CC avenue</font></b>");
		childtest.log(Status.INFO, "<a href=https://shop.unicityqa.com/master/#/home>"+"shop qa url"+"</a>");
		
		LP.UserLogin(username, password);
		HP.home(username);
		CP.add_products_to_cart(username);
		CP.check_product();
		CP.check_cart();
		CO.check_form_fields();
		PP.payment_avenue();
		PP.order_summary();
		CCA.ccavenue_payment_details();
		
	}

}
