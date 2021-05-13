package POM;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;

public class Home extends SuperTestNG {

	@FindBy(xpath = "//a[@ng-click='app.logoRedirect()']")
	private WebElement UnicityLogo;

	@FindBy(xpath = "//div[@class='message ng-binding']")
	private WebElement ViewingProducts;

	@FindBy(xpath = "//div[contains(@title, 'Grid')]")
	private WebElement Grid;

	@FindBy(xpath = "//div[contains(@title, 'List')]")
	private WebElement List;

	@FindBy(xpath = "//translate[text()= 'All Products']")
	private WebElement ALLProducts;

	@FindBy(xpath = "//a[@href='#/home/Products']")
	private WebElement ProductsOnly;

	@FindBy(xpath = "//a[@href='#/home/Accessories']")
	private WebElement Accessories;

	@FindBys(@FindBy(xpath = "//a[@class='name-text uppercase ng-binding']"))
	List<WebElement> Products;

	@FindBys(@FindBy(xpath = "//span[@ng-show='p.terms.taxInclusive']"))
	List<WebElement> ProductPrices;

	@FindBys(@FindBy(xpath = "//span[@class = 'item-number uppercase ng-binding']"))
	List<WebElement> ProductItemCode;

	@FindBys(@FindBy(xpath = "//div[@class = 'item-number uppercase ng-binding']"))
	List<WebElement> ListProductItemCode;

	@FindBys(@FindBy(xpath = "//div[@class = 'item-number uppercase ng-binding']"))
	List<WebElement> ListViewProductItemCode;

	@FindBys(@FindBy(xpath = "//span[contains(@class, 'pv-amount')]"))
	List<WebElement> ProductPV;

	@FindBys(@FindBy(xpath = "//select[@ng-model='p.qty']//option"))
	List<WebElement> ProductQty;

	@FindBys(@FindBy(xpath = "//button[@title='Add to Cart']"))
	List<WebElement> ProductAddtoCart;

	@FindBy(xpath = "//h2")
	private WebElement ProductName;

	@FindBy(xpath = "(//div[@class='price']//span[@class='ng-binding'])[2]")
	private WebElement ProductPrice;

	@FindBy(xpath = "//span[contains(@class,'item-number')]")
	private WebElement ProductItemNumber;

	@FindBy(xpath = "//div[@class='price']//span[contains(@class,'pv')]")
	private WebElement Productpv;

	@FindBy(xpath = "//button[contains(@class, 'share')]")
	private WebElement ShareLink;

	@FindBy(xpath = "//div[@class='container en']/div[@class='row']/div")
	private WebElement ProductDescription;

	@FindBy(xpath = "//span[@class='icon-arrow']")
	private WebElement Back;

	@FindBy(xpath = "//div[contains(@class, 'message')]")
	private WebElement CurrentState;

	@FindBys(@FindBy(xpath = "//div[contains(@class, 'dont-')]//select[contains(@ng-model, 'selectedLanguage')]//option"))
	List<WebElement> Languages;

	@FindBy(xpath = "//translate[text()='Country']")
	private WebElement Country;

	@FindBy(xpath = "//span[contains(text(),'india')]")
	private WebElement SelectedCountry;

	@FindBy(xpath = "//span[contains(@class, 'pv-align')]")
	private WebElement CartPV;

	@FindBy(xpath = "//span[contains(@class, 'total-text')]")
	private WebElement CartPrice;

	@FindBy(xpath = "//span[contains(@class, 'qty-icon')]")
	private WebElement CartQty;

	@FindBy(xpath = "//span[@class= 'icon-arrow_up_color arrow']")
	private WebElement MyUnicity;

	@FindBy(xpath = "//a[contains(text(),'Unicity.com')]")
	private WebElement Unicitydotcom;

	@FindBy(xpath = "//translate[contains(text(),'Office')]")
	private WebElement Officedotcom;

	@FindBy(xpath = "//translate[contains(text(),'Library')]")
	private WebElement Library;

	@FindBy(xpath = "(//div[contains(@class,'customer-id')])[1]")
	private WebElement DistributorName;

	@FindBy(xpath = "(//div[contains(@class,'customer-id')])[2]")
	private WebElement DistributorID;

	@FindBy(xpath = "//span[@class= 'search']")
	private WebElement Search;

	@FindBy(xpath = "//input[contains(@ng-model, 'searchFilter')]")
	private WebElement SearchProduct;

	@FindBy(xpath = "//div[@class= 'name']//a[contains(@href, '#/product-info')]")
	private WebElement Name;

	@FindBy(xpath = "//span[@ng-show='p.terms.taxInclusive']")
	private WebElement Price;

	@FindBy(xpath = "//span[@class = 'item-number uppercase ng-binding']")
	private WebElement ItemCode;

	@FindBy(xpath = "//span[contains(@class, 'pv-amount')]")
	private WebElement PV;

	@FindBy(xpath = "//button[@title='Add to Cart']")
	private WebElement AddtoCart;

	@FindBy(xpath = "//a[@class='name-text uppercase ng-binding']")
	private WebElement SearchProductClick;

	@FindBys(@FindBy(xpath = "//select[contains(@ng-show, 'data.qty')]//option"))
	List<WebElement> SingleProductQty;

	@FindBy(xpath = "//button[@title='Add to Cart']")
	private WebElement SingleAddtoCart;

	@FindBy(xpath = "//span[contains(@class, 'icon-cart')]")
	private WebElement Cart;

	@FindBy(xpath = "//div[contains(@title,'in a List')]")
	private WebElement ListView;

	@FindBys(@FindBy(xpath = "//a[contains(@class, 'name-word')]"))
	List<WebElement> ListViewProductName;

	@FindBys(@FindBy(xpath = "//div[contains(@class, 'pv-grid')]"))
	List<WebElement> ListViewProductPV;

	@FindBys(@FindBy(xpath = "//span[contains(@class, 'icon-minus')]"))
	List<WebElement> ListViewMinus;

	@FindBys(@FindBy(xpath = "//input[@ng-model='p.listQty']"))
	List<WebElement> ListViewQty;

	@FindBys(@FindBy(xpath = "//span[contains(@class, 'icon-plus')]"))
	List<WebElement> ListViewPlus;

	@FindBy(xpath = "//a[@ng-click='app.logout()']")
	private WebElement LogOut;

	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void RetailMenu() throws InterruptedException {
		childtest.log(Status.INFO, "<b><font color=green>Retail Menu</font></b>");
		Thread.sleep(10000);
		Assert.assertTrue(UnicityLogo.isDisplayed());
		Assert.assertEquals(ViewingProducts.getText(), "You are currently viewing product in Karnataka");

		String[] languages = { "ENGLISH", "HINDI", };
		for (int i = 0; i < languages.length; i++) {
			Assert.assertEquals(languages[i], Languages.get(i).getText());
		}

		Thread.sleep(3000);
		Country.click();
		Assert.assertEquals(SelectedCountry.getText(), "India");

		Assert.assertEquals(CartPrice.getText(), "₹0.00");
		Assert.assertEquals(CartQty.getText(), "0");

	}

	public void RetailMenuAfterUserCreated() {
		MyUnicity.click();

		Assert.assertTrue(Unicitydotcom.isDisplayed());
		Assert.assertTrue(Officedotcom.isDisplayed());

		Assert.assertEquals(DistributorName.getText(), userdata.get("fname") + " " + userdata.get("lname"));
		Assert.assertTrue(DistributorID.isDisplayed());
	}

	public void CommonMenu(String username) throws InterruptedException, IOException {
		childtest.log(Status.INFO, "<b><font color=green>Home Page</font></b>");
		Thread.sleep(10000);
		Assert.assertTrue(UnicityLogo.isDisplayed());
		childtest.log(Status.INFO, "Unicity Logo");
		Assert.assertEquals(ViewingProducts.getText(),
				"You are currently viewing product in " + getTranslation(username));
		childtest.log(Status.INFO, "Viewing Products in State" + getTranslation(username));
	}

	public void Menu(String username) throws InterruptedException, IOException {
		childtest.log(Status.INFO, "<b><font color=green>Home Page Menu</font></b>");

		String[] languages = { "ENGLISH", "HINDI", };
		for (int i = 0; i < languages.length; i++) {
			Assert.assertEquals(languages[i], Languages.get(i).getText());
		}

		Thread.sleep(10000);
		childtest.log(Status.INFO, "Checking Languages");
		MyUnicity.click();
		Assert.assertTrue(Unicitydotcom.isDisplayed());
		Assert.assertTrue(Officedotcom.isDisplayed());
		Assert.assertTrue(Library.isDisplayed());
		Assert.assertEquals(DistributorName.getText(), getTranslation(username + "Name").toUpperCase());
		childtest.log(Status.INFO, "Checking Distributor Name" + getTranslation(username + "Name").toUpperCase());
		Assert.assertEquals(DistributorID.getText(), getTranslation(username + "ID"));
		childtest.log(Status.INFO, "Checking Distributor Name" + getTranslation(username + "ID"));
		Thread.sleep(5000);

		Country.click();
		Thread.sleep(5000);
		Assert.assertEquals(SelectedCountry.getText(), "India");

		Assert.assertEquals(CartPV.getText(), "PV: 0");
		Assert.assertEquals(CartPrice.getText(), "₹0.00");
		Assert.assertEquals(CartQty.getText(), "0");
		childtest.log(Status.INFO, "Checking Cart should be Empty");
	}

	public void Search() throws IOException, InterruptedException {
		childtest.log(Status.INFO, "<b><font color=green>Product Search</font></b>");
		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);

		Search.click();
		SearchProduct.sendKeys("Activate (30 Sachets)");
		Assert.assertEquals("ACTIVATE (30 SACHETS)", Name.getText());
		Assert.assertEquals(p.getProperty(Name.getText().replace(" ", "") + "CODE"), ItemCode.getText());
		Assert.assertEquals("₹" + p.getProperty(Name.getText().replace(" ", "") + "PRICE"), Price.getText());
		Assert.assertEquals(p.getProperty(Name.getText().replace(" ", "") + "PV"), PV.getText().replace("PV: ", ""));
		childtest.log(Status.INFO, "Checking Price, PV, Item Code for Searched Product");
		Assert.assertTrue(AddtoCart.isDisplayed());

		for (int j = 0; j < qty.length; j++) {
			Assert.assertEquals(ProductQty.get(j).getText(), qty[j]);
		}

		SearchProductClick.click();

		Assert.assertEquals("ACTIVATE (30 SACHETS)", ProductName.getText());
		Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
				ProductItemNumber.getText());
		Assert.assertEquals("₹" + p.getProperty(ProductName.getText().replace(" ", "") + "PRICE").replace(",", ""),
				ProductPrice.getText().replace(" ", "") + " Tax Included");
		Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "PV"),
				Productpv.getText().replace("PV: ", ""));
		Thread.sleep(5000);
		for (int j = 0; j < qty.length; j++) {
			Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
		}
		childtest.log(Status.INFO, ProductName.getText());
		childtest.log(Status.INFO, ProductItemNumber.getText());
		childtest.log(Status.INFO, ProductPrice.getText());
		childtest.log(Status.INFO, Productpv.getText());

		Assert.assertTrue(ShareLink.isDisplayed());
		Assert.assertTrue(SingleAddtoCart.isDisplayed());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		// Assert.assertEquals(ProductDescription.getText(),
		// p.getProperty(ProductName.getText().replace(" ", "")));
		Back.click();
		childtest.log(Status.INFO, "Go Back");
	}

	public void AllProducts() throws InterruptedException, IOException {
		Thread.sleep(5000);

		childtest.log(Status.INFO, "<b><font color=green>ALL Products</font></b>");

		Assert.assertEquals(CurrentState.getText(), "You are currently viewing product in Karnataka");
		ALLProducts.click();

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);

		for (int i = 0; i < allproducts.length; i++) {
			Assert.assertEquals(Products.get(i).getText(), allproducts[i]);
			Assert.assertEquals(p.getProperty(Products.get(i).getText().replace(" ", "") + "CODE"),
					ProductItemCode.get(i).getText());

			Assert.assertEquals("₹" + p.getProperty(Products.get(i).getText().replace(" ", "") + "PRICE"),
					ProductPrices.get(i).getText());

			Assert.assertEquals(p.getProperty(Products.get(i).getText().replace(" ", "") + "PV"),
					ProductPV.get(i).getText().replace("PV: ", ""));

			childtest.log(Status.INFO, Products.get(i).getText() + "   " + ProductPV.get(i).getText() + "   "
					+ ProductItemCode.get(i).getText() + "  " + ProductPrices.get(i).getText());

			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(ProductQty.get(j).getText(), qty[j]);
			}

			Assert.assertTrue(ProductAddtoCart.get(i).isDisplayed());

			Products.get(i).click();

			Assert.assertEquals(allproducts[i], ProductName.getText());

			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals("₹" + p.getProperty(ProductName.getText().replace(" ", "") + "PRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "PV"),
					Productpv.getText().replace("PV: ", ""));
			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			// Assert.assertEquals(ProductDescription.getText(),
			// p.getProperty(ProductName.getText().replace(" ", "")));
			Back.click();
			// SingleAddtoCart.click();
			// Cart.click();
		}
	}

	public void Products() throws IOException, InterruptedException {

		childtest.log(Status.INFO, "<b><font color=green>Products</font></b>");

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);

		ProductsOnly.click();

		for (int i = 0; i < products.length; i++) {
			Assert.assertEquals(Products.get(i).getText(), products[i]);

			Assert.assertEquals(p.getProperty(Products.get(i).getText().replace(" ", "") + "CODE"),
					ProductItemCode.get(i).getText());

			Assert.assertEquals("₹" + p.getProperty(Products.get(i).getText().replace(" ", "") + "PRICE"),
					ProductPrices.get(i).getText());

			Assert.assertEquals(p.getProperty(Products.get(i).getText().replace(" ", "") + "PV"),
					ProductPV.get(i).getText().replace("PV: ", ""));

			childtest.log(Status.INFO, Products.get(i).getText() + "   " + ProductPV.get(i).getText() + "   "
					+ ProductItemCode.get(i).getText() + "  " + ProductPrices.get(i).getText());

			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(ProductQty.get(j).getText(), qty[j]);
			}

			Assert.assertTrue(ProductAddtoCart.get(i).isDisplayed());

			Products.get(i).click();

			Assert.assertEquals(products[i], ProductName.getText());
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals("₹" + p.getProperty(ProductName.getText().replace(" ", "") + "PRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "PV"),
					Productpv.getText().replace("PV: ", ""));
			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			// Assert.assertEquals(ProductDescription.getText(),
			// p.getProperty(ProductName.getText().replace(" ", "")));
			Back.click();

		}
	}

	public void Accessories() throws IOException, InterruptedException {

		childtest.log(Status.INFO, "<b><font color=green>Accessories</font></b>");

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);

		Accessories.click();

		for (int i = 0; i < accessories.length; i++) {
			Assert.assertEquals(Products.get(i).getText(), accessories[i]);

			Assert.assertEquals(p.getProperty(Products.get(i).getText().replace(" ", "") + "CODE"),
					ProductItemCode.get(i).getText());

			Assert.assertEquals("₹" + p.getProperty(Products.get(i).getText().replace(" ", "") + "PRICE"),
					ProductPrices.get(i).getText());

			Assert.assertEquals(p.getProperty(Products.get(i).getText().replace(" ", "") + "PV"),
					ProductPV.get(i).getText().replace("PV: ", ""));

			childtest.log(Status.INFO, Products.get(i).getText() + "   " + ProductPV.get(i).getText() + "   "
					+ ProductItemCode.get(i).getText() + "  " + ProductPrices.get(i).getText());

			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(ProductQty.get(j).getText(), qty[j]);
			}

			Assert.assertTrue(ProductAddtoCart.get(i).isDisplayed());

			Products.get(i).click();

			Assert.assertEquals(accessories[i], ProductName.getText());
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals("₹" + p.getProperty(ProductName.getText().replace(" ", "") + "PRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "PV"),
					Productpv.getText().replace("PV: ", ""));
			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			// Assert.assertEquals(ProductDescription.getText(),
			// p.getProperty(ProductName.getText().replace(" ", "")));
			Back.click();
		}
	}

	public void ALLProductsList() throws IOException, InterruptedException {
		ListView.click();
		ALLProducts.click();

		childtest.log(Status.INFO, "<b><font color=green>ALL Products List View</font></b>");

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);
		Thread.sleep(2000);
		Assert.assertTrue(AddtoCart.isDisplayed());
		for (int i = 0; i < allproducts.length; i++) {
			Assert.assertEquals(ListViewProductName.get(i).getText(), allproducts[i]);
			Assert.assertEquals(p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "CODE"),
					ListViewProductItemCode.get(i).getText());
			Assert.assertEquals("₹" + p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "PRICE"),
					"₹" + ProductPrices.get(i).getText());

			Assert.assertEquals(p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "PV"),
					ListViewProductPV.get(i).getText().replace("PV: ", ""));

			childtest.log(Status.INFO, ListViewProductName.get(i).getText() + "   " + ListViewProductPV.get(i).getText()
					+ "   " + ListViewProductItemCode.get(i).getText() + "  " + ProductPrices.get(i).getText());

			Assert.assertTrue(ListViewMinus.get(i).isDisplayed());
			Assert.assertTrue(ListViewQty.get(i).isDisplayed());
			Assert.assertTrue(ListViewPlus.get(i).isDisplayed());

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", ListViewProductName.get(i));

			ListViewProductName.get(i).click();

			Assert.assertEquals(allproducts[i], ProductName.getText());
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals("₹" + p.getProperty(ProductName.getText().replace(" ", "") + "PRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "PV"),
					Productpv.getText().replace("PV: ", ""));
			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			jse.executeScript("window.scrollBy(0,250)", "");
			// Assert.assertEquals(ProductDescription.getText(),
			// p.getProperty(ProductName.getText().replace(" ", "")));
			Back.click();
		}
	}

	public void ProductsList() throws IOException, InterruptedException {

		childtest.log(Status.INFO, "<b><font color=green>Products List View</font></b>");

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);

		ProductsOnly.click();

		Assert.assertTrue(AddtoCart.isDisplayed());
		for (int i = 0; i < products.length; i++) {
			Assert.assertEquals(ListViewProductName.get(i).getText(), products[i]);
			Assert.assertEquals(p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "CODE"),
					ListViewProductItemCode.get(i).getText());
			Assert.assertEquals("₹" + p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "PRICE"),
					"₹" + ProductPrices.get(i).getText());

			Assert.assertEquals(p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "PV"),
					ListViewProductPV.get(i).getText().replace("PV: ", ""));

			Assert.assertTrue(ListViewMinus.get(i).isDisplayed());
			Assert.assertTrue(ListViewQty.get(i).isDisplayed());
			Assert.assertTrue(ListViewPlus.get(i).isDisplayed());

			childtest.log(Status.INFO, ListViewProductName.get(i).getText() + "   " + ListViewProductPV.get(i).getText()
					+ "   " + ListViewProductItemCode.get(i).getText() + "  " + ProductPrices.get(i).getText());

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", ListViewProductName.get(i));

			ListViewProductName.get(i).click();

			Assert.assertEquals(products[i], ProductName.getText());
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals("₹" + p.getProperty(ProductName.getText().replace(" ", "") + "PRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "PV"),
					Productpv.getText().replace("PV: ", ""));
			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			jse.executeScript("window.scrollBy(0,250)", "");
			// Assert.assertEquals(ProductDescription.getText(),
			// p.getProperty(ProductName.getText().replace(" ", "")));
			Back.click();
		}
	}

	public void AccessoriesList() throws IOException, InterruptedException {

		childtest.log(Status.INFO, "<b><font color=green>Accessories List View</font></b>");

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);

		Accessories.click();
		Assert.assertTrue(AddtoCart.isDisplayed());
		for (int i = 0; i < accessories.length; i++) {
			Assert.assertEquals(ListViewProductName.get(i).getText(), accessories[i]);
			Assert.assertEquals(p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "CODE"),
					ListViewProductItemCode.get(i).getText());
			Assert.assertEquals("₹" + p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "PRICE"),
					"₹" + ProductPrices.get(i).getText());

			Assert.assertEquals(p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "PV"),
					ListViewProductPV.get(i).getText().replace("PV: ", ""));

			childtest.log(Status.INFO, ListViewProductName.get(i).getText() + "   " + ListViewProductPV.get(i).getText()
					+ "   " + ListViewProductItemCode.get(i).getText() + "  " + ProductPrices.get(i).getText());

			Assert.assertTrue(ListViewMinus.get(i).isDisplayed());
			Assert.assertTrue(ListViewQty.get(i).isDisplayed());
			Assert.assertTrue(ListViewPlus.get(i).isDisplayed());

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", ListViewProductName.get(i));

			ListViewProductName.get(i).click();

			Assert.assertEquals(accessories[i], ProductName.getText());
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals("₹" + p.getProperty(ProductName.getText().replace(" ", "") + "PRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "PV"),
					Productpv.getText().replace("PV: ", ""));
			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			jse.executeScript("window.scrollBy(0,250)", "");
			// Assert.assertEquals(ProductDescription.getText(),
			// p.getProperty(ProductName.getText().replace(" ", "")));
			Back.click();
		}
	}

	public void RetailAllProducts() throws InterruptedException, IOException {
		Thread.sleep(5000);

		childtest.log(Status.INFO, "<b><font color=green>Retail All products in Grid View</font></b>");

		Assert.assertEquals(CurrentState.getText(), "You are currently viewing product in Karnataka");
		ALLProducts.click();

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);

		for (int i = 0; i < retailallproducts.length; i++) {
			Assert.assertEquals(Products.get(i).getText(), retailallproducts[i]);
			Assert.assertEquals(p.getProperty(Products.get(i).getText().replace(" ", "") + "CODE"),
					ProductItemCode.get(i).getText());

			Assert.assertEquals("₹" + p.getProperty(Products.get(i).getText().replace(" ", "") + "RETAILPRICE"),
					ProductPrices.get(i).getText());

			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(ProductQty.get(j).getText(), qty[j]);
			}

			Assert.assertTrue(ProductAddtoCart.get(i).isDisplayed());

			childtest.log(Status.INFO, Products.get(i).getText() + "   " + "   " + ProductItemCode.get(i).getText()
					+ "  " + ProductPrices.get(i).getText());

			Products.get(i).click();

			childtest.log(Status.INFO, "Click on Product");

			Assert.assertEquals(retailallproducts[i], ProductName.getText());
			childtest.log(Status.INFO, ProductName.getText());

			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			childtest.log(Status.INFO, ProductItemNumber.getText());

			Assert.assertEquals(
					"₹" + p.getProperty(ProductName.getText().replace(" ", "") + "RETAILPRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");
			childtest.log(Status.INFO, ProductPrice.getText());

			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			childtest.log(Status.INFO, "Share Link");

			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			childtest.log(Status.INFO, "Quantity [1, 2, 3, 4, 5, 6, 7, 8, 9, 10+]");

			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			childtest.log(Status.INFO, "Add To Cart");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			/*
			 * Assert.assertEquals(ProductDescription.getText(),
			 * p.getProperty(ProductName.getText().replace(" ", "")));
			 */
			Back.click();
			childtest.log(Status.INFO, "GO Back");
		}
	}

	public void RetailProducts() throws IOException, InterruptedException {

		childtest.log(Status.INFO, "<b><font color=green>Retail products in Grid View</font></b>");

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);

		ProductsOnly.click();

		for (int i = 0; i < retailproducts.length; i++) {
			Assert.assertEquals(Products.get(i).getText(), retailproducts[i]);
			Assert.assertEquals(p.getProperty(Products.get(i).getText().replace(" ", "") + "CODE"),
					ProductItemCode.get(i).getText());

			Assert.assertEquals("₹" + p.getProperty(Products.get(i).getText().replace(" ", "") + "RETAILPRICE"),
					ProductPrices.get(i).getText());

			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(ProductQty.get(j).getText(), qty[j]);
			}

			childtest.log(Status.INFO, Products.get(i).getText() + "   " + "   " + ProductItemCode.get(i).getText()
					+ "  " + ProductPrices.get(i).getText());

			Assert.assertTrue(ProductAddtoCart.get(i).isDisplayed());

			Products.get(i).click();

			Assert.assertEquals(retailproducts[i], ProductName.getText());
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals(
					"₹" + p.getProperty(ProductName.getText().replace(" ", "") + "RETAILPRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");

			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			/*
			 * Assert.assertEquals(ProductDescription.getText(),
			 * p.getProperty(ProductName.getText().replace(" ", "")));
			 */
			Back.click();

		}
	}

	public void RetailAccessories() throws IOException, InterruptedException {

		childtest.log(Status.INFO, "<b><font color=green>Retail Accessories in Grid View</font></b>");

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);

		Accessories.click();

		for (int i = 0; i < retailaccessories.length; i++) {
			Assert.assertEquals(Products.get(i).getText(), retailaccessories[i]);
			Assert.assertEquals(p.getProperty(Products.get(i).getText().replace(" ", "") + "CODE"),
					ProductItemCode.get(i).getText());

			Assert.assertEquals("₹" + p.getProperty(Products.get(i).getText().replace(" ", "") + "RETAILPRICE"),
					ProductPrices.get(i).getText());

			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(ProductQty.get(j).getText(), qty[j]);
			}

			Assert.assertTrue(ProductAddtoCart.get(i).isDisplayed());

			childtest.log(Status.INFO, Products.get(i).getText() + "   " + "   " + ProductItemCode.get(i).getText()
					+ "  " + ProductPrices.get(i).getText());

			Products.get(i).click();

			Assert.assertEquals(accessories[i], ProductName.getText());
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals(
					"₹" + p.getProperty(ProductName.getText().replace(" ", "") + "RETAILPRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");

			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			/*
			 * Assert.assertEquals(ProductDescription.getText(),
			 * p.getProperty(ProductName.getText().replace(" ", "")));
			 */
			Back.click();
		}
	}

	public void RetailALLProductsList() throws IOException, InterruptedException {

		childtest.log(Status.INFO, "<b><font color=green>Retail All products in List View</font></b>");

		ListView.click();
		ALLProducts.click();
		childtest.log(Status.INFO, "Retail All products in List View");
		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);
		Thread.sleep(2000);
		Assert.assertTrue(AddtoCart.isDisplayed());
		for (int i = 0; i < retailallproducts.length; i++) {
			Assert.assertEquals(ListViewProductName.get(i).getText(), retailallproducts[i]);
			Assert.assertEquals(p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "CODE"),
					ListProductItemCode.get(i).getText());
			Assert.assertEquals(
					"₹" + p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "RETAILPRICE"),
					"₹" + ProductPrices.get(i).getText());

			childtest.log(Status.INFO, ListViewProductName.get(i).getText() + "   " + "   "
					+ ListViewProductItemCode.get(i).getText() + "  " + ProductPrices.get(i).getText());

			Assert.assertTrue(ListViewMinus.get(i).isDisplayed());
			Assert.assertTrue(ListViewQty.get(i).isDisplayed());
			Assert.assertTrue(ListViewPlus.get(i).isDisplayed());

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", ListViewProductName.get(i));

			ListViewProductName.get(i).click();

			Assert.assertEquals(retailallproducts[i], ProductName.getText());
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals(
					"₹" + p.getProperty(ProductName.getText().replace(" ", "") + "RETAILPRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");

			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			jse.executeScript("window.scrollBy(0,250)", "");
			/*
			 * Assert.assertEquals(ProductDescription.getText(),
			 * p.getProperty(ProductName.getText().replace(" ", "")));
			 */
			Back.click();
		}
	}

	public void RetailProductsList() throws IOException, InterruptedException {

		childtest.log(Status.INFO, "<b><font color=green>Retail products in List View</font></b>");

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);
		childtest.log(Status.INFO, "Retail products in List View");
		ProductsOnly.click();
		Assert.assertTrue(AddtoCart.isDisplayed());
		for (int i = 0; i < retailproducts.length; i++) {
			Assert.assertEquals(ListViewProductName.get(i).getText(), retailproducts[i]);
			Assert.assertEquals(p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "CODE"),
					ListProductItemCode.get(i).getText());
			Assert.assertEquals(
					"₹" + p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "RETAILPRICE"),
					"₹" + ProductPrices.get(i).getText());

			Assert.assertTrue(ListViewMinus.get(i).isDisplayed());
			Assert.assertTrue(ListViewQty.get(i).isDisplayed());
			Assert.assertTrue(ListViewPlus.get(i).isDisplayed());

			childtest.log(Status.INFO, ListViewProductName.get(i).getText() + "   " + "   "
					+ ListViewProductItemCode.get(i).getText() + "  " + ProductPrices.get(i).getText());

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", ListViewProductName.get(i));

			ListViewProductName.get(i).click();

			Assert.assertEquals(retailproducts[i], ProductName.getText());
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals(
					"₹" + p.getProperty(ProductName.getText().replace(" ", "") + "RETAILPRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");

			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			jse.executeScript("window.scrollBy(0,250)", "");
			/*
			 * Assert.assertEquals(ProductDescription.getText(),
			 * p.getProperty(ProductName.getText().replace(" ", "")));
			 */
			Back.click();
		}
	}

	public void RetailAccessoriesList() throws IOException, InterruptedException {

		childtest.log(Status.INFO, "<b><font color=green>Retail Accessories in List View</font></b>");

		FileReader type = new FileReader(
				"C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties");
		Properties p = new Properties();
		p.load(type);
		childtest.log(Status.INFO, "Retail Accessories in List View");
		Accessories.click();
		Assert.assertTrue(AddtoCart.isDisplayed());
		for (int i = 0; i < retailaccessories.length; i++) {
			Assert.assertEquals(ListViewProductName.get(i).getText(), retailaccessories[i]);
			Assert.assertEquals(p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "CODE"),
					ListProductItemCode.get(i).getText());
			Assert.assertEquals(
					"₹" + p.getProperty(ListViewProductName.get(i).getText().replace(" ", "") + "RETAILPRICE"),
					"₹" + ProductPrices.get(i).getText());

			Assert.assertTrue(ListViewMinus.get(i).isDisplayed());
			Assert.assertTrue(ListViewQty.get(i).isDisplayed());
			Assert.assertTrue(ListViewPlus.get(i).isDisplayed());

			childtest.log(Status.INFO, ListViewProductName.get(i).getText() + "   " + "   "
					+ ListViewProductItemCode.get(i).getText() + "  " + ProductPrices.get(i).getText());

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", ListViewProductName.get(i));

			ListViewProductName.get(i).click();

			Assert.assertEquals(retailaccessories[i], ProductName.getText());
			Assert.assertEquals(p.getProperty(ProductName.getText().replace(" ", "") + "CODE"),
					ProductItemNumber.getText());
			Assert.assertEquals(
					"₹" + p.getProperty(ProductName.getText().replace(" ", "") + "RETAILPRICE").replace(",", ""),
					ProductPrice.getText().replace(" ", "") + " Tax Included");

			Thread.sleep(5000);
			Assert.assertTrue(ShareLink.isDisplayed());
			for (int j = 0; j < qty.length; j++) {
				Assert.assertEquals(SingleProductQty.get(j).getText(), qty[j]);
			}
			Assert.assertTrue(SingleAddtoCart.isDisplayed());
			jse.executeScript("window.scrollBy(0,250)", "");
			/*
			 * Assert.assertEquals(ProductDescription.getText(),
			 * p.getProperty(ProductName.getText().replace(" ", "")));
			 */
			Back.click();
		}
	}

	public void Logout() {
		childtest.log(Status.INFO, "<b><font color=green>LogOut</font></b>");
		LogOut.click();
		childtest.log(Status.INFO, "LogOut");
	}

}
