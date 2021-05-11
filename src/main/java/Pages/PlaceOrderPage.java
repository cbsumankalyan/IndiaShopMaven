package Pages;

import java.io.IOException;
import POM.Home;
import POM.PlaceOrder;


public class PlaceOrderPage extends SuperTestNG {
	
	
	
	
	public void placed_order_fields(String username) throws InterruptedException, IOException{
		Home Home = new Home(driver);
		PlaceOrder placeorder = new PlaceOrder(driver);
		Home.CommonMenu(username);
		placeorder.PlaceOrderFields();
	}
	
	public void retail_placed_order_fields() throws InterruptedException, IOException{
		PlaceOrder placeorder = new PlaceOrder(driver);
		placeorder.PlaceOrderFields();
	}
	
	public void placed_shipping_information(){
		PlaceOrder placeorder = new PlaceOrder(driver);
		placeorder.shipping();
	}
	
	public void placed_retail_shipping_information(){
		PlaceOrder placeorder = new PlaceOrder(driver);
		placeorder.retailshipping();
	}
	
	public void placed_contact_information(){
		PlaceOrder placeorder = new PlaceOrder(driver);
		placeorder.contact();
	}
	
	public void placed_payment_information(){
		PlaceOrder placeorder = new PlaceOrder(driver);
		placeorder.payment();
	}
	
	public void placed() throws InterruptedException{
		PlaceOrder placeorder = new PlaceOrder(driver);
		placeorder.Orders();
	}
	
	public void retail_placed() throws InterruptedException{
		PlaceOrder placeorder = new PlaceOrder(driver);
		placeorder.RetailOrders();
	}
	
	public void return_home(String username) throws InterruptedException, IOException{
		Home Home = new Home(driver);
		PlaceOrder placeorder = new PlaceOrder(driver);
		placeorder.ReturnHome();
		Thread.sleep(5000);
		Home.CommonMenu(username);
		Home.Menu(username);
	}
	
	public void retail_return_home() throws InterruptedException, IOException{
		Home Home = new Home(driver);
		PlaceOrder placeorder = new PlaceOrder(driver);
		placeorder.ReturnHome();
		Thread.sleep(5000);
		Home.RetailMenu();
		Home.RetailMenuAfterUserCreated();
	}
}
