package Pages;

import java.io.IOException;
import POM.Home;
import POM.Login;

public class HomePage extends SuperTestNG {
	
	
	
	public void select_state() throws InterruptedException{
		Login Login = new Login(driver);
		Login.SelectState();
	}
	
	public void retail_home_page() throws InterruptedException{
		Home Home = new Home(driver);
		Home.RetailMenu();
	}
	
	public void home(String username) throws InterruptedException, IOException{
		Home Home = new Home(driver);
		Home.CommonMenu(username);
		Home.Menu(username);
	}
	
	public void all_producst() throws InterruptedException, IOException {
		Home Home = new Home(driver);
		Home.AllProducts();
	}
	
	public void products() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.Products();
	}
	
	public void accessories() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.Accessories();
	}

	public void retail_all_producst() throws InterruptedException, IOException {
		Home Home = new Home(driver);
		Home.RetailAllProducts();
	}
	
	public void retail_products() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.RetailProducts();
	}
	
	public void retail_accessories() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.RetailAccessories();
	}
	
	public void search_product() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.Search();
	}
	
	public void all_products_in_list_view() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.ALLProductsList();
	}
	
	public void products_in_list_view() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.ProductsList();
	}
	
	public void accessories_in_list_view() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.AccessoriesList();
	}
	
	public void reatil_all_products_in_list_view() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.RetailALLProductsList();
	}
	
	public void retail_products_in_list_view() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.RetailProductsList();
	}
	
	public void retail_accessories_in_list_view() throws IOException, InterruptedException {
		Home Home = new Home(driver);
		Home.RetailAccessoriesList();
	}
	
	public void logout(){
		Home Home = new Home(driver);
		Home.Logout();
	}

}
