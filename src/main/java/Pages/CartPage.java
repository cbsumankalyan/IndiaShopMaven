package Pages;

import java.io.IOException;
import POM.Cart;
import POM.Home;

public class CartPage extends SuperTestNG {
	
	
	

	public void added_retail_product_to_cart() throws InterruptedException{
		Cart cartpage = new Cart(driver);
		cartpage.cart();
	}
	
	public void  product_added_to_cart(String username) throws InterruptedException, IOException {
		Home Home = new Home(driver);
		Cart cartpage = new Cart(driver);
		cartpage.cart();
		Home.CommonMenu(username);
	}
	
	public void check_the_cart_details() throws InterruptedException, IOException {
		Cart cartpage = new Cart(driver);
		cartpage.cartdetails();
	}
	
	public void check_the_retail_cart_details() throws InterruptedException, IOException {
		Cart cartpage = new Cart(driver);
		cartpage.retailcartdetails();
	}
	
	public void remove_products_from_cart() throws InterruptedException {
		Cart cartpage = new Cart(driver);
		cartpage.removeproduct();
	}
	
	public void remove_retail_products_from_cart() throws InterruptedException {
		Cart cartpage = new Cart(driver);
		cartpage.removeretailproduct();
	}
	
	public void add_retail_products_to_cart() throws InterruptedException, IOException {
		Cart cartpage = new Cart(driver);
		cartpage.addretailproduct();
	}
	
	public void add_products_to_cart(String username) throws InterruptedException, IOException {
		Home Home = new Home(driver);
		Cart cartpage = new Cart(driver);
		Home.CommonMenu(username);
		cartpage.addproduct();
	}
	
	public void check_product() throws InterruptedException, IOException {
		Cart cartpage = new Cart(driver);
		cartpage.checkproduct();
	}
	
	public void check_retail_product() throws InterruptedException, IOException {
		Cart cartpage = new Cart(driver);
		cartpage.checkretailproduct();
	}
	
	public void check_cart() throws IOException, InterruptedException {
		Cart cartpage = new Cart(driver);
		cartpage.checkcart();
	}
	
	public void check_retail_cart() throws IOException, InterruptedException {
		Cart cartpage = new Cart(driver);
		cartpage.checkretailcart();
	}
	
	public void sign_up_retail_customer() throws InterruptedException, IOException{
		Cart cartpage = new Cart(driver);
		cartpage.signupretail();
		cartpage.checkretailcart();
	}
	
	
}
