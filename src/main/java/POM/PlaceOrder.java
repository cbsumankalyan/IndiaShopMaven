package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;

public class PlaceOrder extends SuperTestNG {
	
	@FindBy(xpath = "//a[@ng-click= 'review.goHome()']")
	private WebElement BackToShop;
	
	@FindBy(xpath = "//h1[@ng-show= 'review.orderSaved']")
	private WebElement YourOrderHasBeenPlaced;
	
	@FindBy(xpath = "//div[@class='order-placed-number']/Span[@ng-show='app.isShopping']")
	private WebElement OrderPlacedNumber;
	
	@FindBy(xpath = "//div[@class='order-placed-number']/translate")
	private WebElement Order;
	
	@FindBy(xpath = "//span[@ng-bind-html='alert.msg']")
	private WebElement OrderSuccessfullyPlaced;
	
	@FindBy(xpath = "//p[contains(text(), 'Please Transfer')]")
	private WebElement PleaseTransferFunds;
	
	@FindBy(xpath = "(//div[contains(@ng-repeat, 'key, account')])[1]")
	private WebElement HDFCBank;

	@FindBy(xpath = "(//div[contains(@ng-repeat, 'key, account')])[2]")
	private WebElement SBIBank;

	@FindBy(xpath = "(//div[contains(@ng-repeat, 'key, account')])[3]")
	private WebElement AxisBank;
	
	@FindBy(xpath = "//div[contains(@class, 'questions')]")
	private WebElement ForQuestionsContactCS;
	
	@FindBy(xpath = "(//div[@ng-hide='review.noOrderData']/div/div[@class='row'])[1]")
	private WebElement Shipping;

	@FindBy(xpath = "(//div[@ng-hide='review.noOrderData']/div/div[@class='row'])[2]")
	private WebElement Contact;

	@FindBy(xpath = "(//div[@ng-hide='review.noOrderData']/div/div[@class='row'])[3]")
	private WebElement Payment;
	
	@FindBy(xpath = "//translate[text()='Review Order']")
	private WebElement ReviewOrder;

	@FindBy(xpath = "(//div[@class='product-info-wrapper']/div/span)[1]")
	private WebElement ProductName;

	@FindBy(xpath = "(//div[@class='product-info']/span)[2]")
	private WebElement ProductCode;

	@FindBy(xpath = "(//div[contains(@class,'product-cost')]/span)[1]")
	private WebElement Qty;

	@FindBy(xpath = "//span[@ng-show='p.product.terms.taxInclusive']")
	private WebElement PPPrice;

	@FindBy(xpath = "(//p[@class='total-title row'])[1]/span[2]")
	private WebElement ProductPrice;

	@FindBy(xpath = "//span[contains(@class, 'shipping-value')]")
	private WebElement ShippingPrice;

	@FindBy(xpath = "//p[@ng-show = '!totals.taxInclusiveNoAddTax']//span[contains(@class, 'total-value')]")
	private WebElement TaxPrice;

	@FindBy(xpath = "//p[@class = 'total-title total row']//span[contains(@class, 'total-value')]")
	private WebElement TotalPrice;

	@FindBy(xpath = "(//p[@class='total-title row'])[1]/span[1]")
	private WebElement SUBTOTAL;

	@FindBy(xpath = "(//p[@class='total-title row'])[2]/span[1]")
	private WebElement SHIPPING;

	@FindBy(xpath = "(//p[@class='total-title row'])[3]/span[1]")
	private WebElement TAXES;

	@FindBy(xpath = "(//div[contains(@ng-show, 'userType')]//span)[1]")
	private WebElement PVTOTAL;

	@FindBy(xpath = "(//translate[text()='Total'])[2]")
	private WebElement TOTAL;

	@FindBy(xpath = "//small[contains(@ng-show, 'totals.taxInclusive')]")
	private WebElement AmountWOVat;

	@FindBy(xpath = "(//div[contains(@ng-show, 'userType')]//span)[2]")
	private WebElement TotalPV;
	
	public PlaceOrder(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void PlaceOrderFields() throws InterruptedException{
		
		childtest.log(Status.INFO, "Order Placed Fields");
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='background']")));
		
		Thread.sleep(5000);
		Assert.assertTrue(BackToShop.isDisplayed());
		Assert.assertEquals(YourOrderHasBeenPlaced.getText(), "Your Order Has Been Placed");
		System.out.println(OrderPlacedNumber.getText());
		Assert.assertEquals(Order.getText(), "Order #");
		/*Assert.assertEquals(PleaseTransferFunds.getText(), "Please Transfer Funds to the Following Account:");*/
		Assert.assertEquals(ReviewOrder.getText(), "REVIEW ORDER");
		Assert.assertEquals(ForQuestionsContactCS.getText(), "For questions regarding your order please contact Customer Service.");
		
		Assert.assertTrue(Shipping.isDisplayed());
		Assert.assertTrue(Contact.isDisplayed());
		Assert.assertTrue(Payment.isDisplayed());
	}
	
	public void shipping() {
		childtest.log(Status.INFO, "Shipping Details");
		
		Assert.assertEquals(Shipping.getText(),
				"SHIPPING INFORMATION\nIndia Training\n23/2 2nd floor Khandari Parc Haudin Road\nBangalore, KA, 560042, IN");
	}
	
	public void retailshipping() {
		
		childtest.log(Status.INFO, "Retail Shipping Details");
		Assert.assertEquals(Shipping.getText(),
				"SHIPPING INFORMATION\n"+userdata.get("fname")+" "+userdata.get("lname")+"\n23/2 2nd floor Khandari Parc Haudin Road\nBanglaore, KA, 560042, IN");
	}

	public void contact() {
		
		childtest.log(Status.INFO, "Contact details");
		Assert.assertEquals(Contact.getText(),
				"CONTACT INFORMATION\nPhone: 9019185440\nEmail: suman.cb@unicity.com");
	}

	public void payment() {
		childtest.log(Status.INFO, "Bank Wire");
		Assert.assertEquals(Payment.getText(), "PAYMENT INFORMATION\nPayment Type: BankWire");
	}

	public void Orders() throws InterruptedException {
		
		childtest.log(Status.INFO, "Order Details");
		
		Thread.sleep(5000);
		Assert.assertEquals(ProductName.getText(), productdetails.get("name"));
		Assert.assertEquals(ProductCode.getText(), productdetails.get("itemcode"));
//		Assert.assertEquals(PPPrice.getText().trim(), productdetails.get("price") + "TaxIncluded");
		Assert.assertEquals(Qty.getText().replace("Qty: ", ""), productdetails.get("qty"));
		System.out.println("dsafasfsadf");
		float pp = Float.parseFloat(ProductPrice.getText().replace("₹", ""));
		float sp = Float.parseFloat(ShippingPrice.getText().replace("₹", ""));
		float tp = Float.parseFloat(TaxPrice.getText().replace("₹", ""));
		float ttp = Float.parseFloat(TotalPrice.getText().replace("₹", "").replace(",", ""));

		Assert.assertEquals(ttp, pp + sp + tp, ttp);

		Assert.assertEquals(SUBTOTAL.getText(), "SUBTOTAL**:");
		Assert.assertEquals(SHIPPING.getText(), "SHIPPING**:");
		Assert.assertEquals(TAXES.getText(), "TAXES:");
		Assert.assertEquals(PVTOTAL.getText(), "PV TOTAL:");
		Assert.assertEquals(TOTAL.getText(), "TOTAL");
		Assert.assertEquals(AmountWOVat.getText(), "** Amounts without GST");
		Assert.assertEquals(TotalPV.getText(), productdetails.get("pv").replace("PV: ", ""));
	}
	
	public void RetailOrders() throws InterruptedException {
		
		childtest.log(Status.INFO, "Retail Order Details");
		
		Thread.sleep(5000);
		Assert.assertEquals(ProductName.getText(), productdetails.get("name"));
		Assert.assertEquals(ProductCode.getText(), productdetails.get("itemcode"));
		/*Assert.assertEquals(PPPrice.getText().trim(), productdetails.get("price") + "TaxIncluded");*/
		Assert.assertEquals(Qty.getText().replace("Qty: ", ""), productdetails.get("qty"));
		float pp = Float.parseFloat(ProductPrice.getText().replace("₹", "").replace(",", ""));
		float sp = Float.parseFloat(ShippingPrice.getText().replace("₹", ""));
		float tp = Float.parseFloat(TaxPrice.getText().replace("₹", ""));
		float ttp = Float.parseFloat(TotalPrice.getText().replace("₹", "").replace(",", ""));
		
		childtest.log(Status.INFO, "ProductPrice   :"+ProductPrice.getText());
		childtest.log(Status.INFO, "ShippingPrice   :"+ShippingPrice.getText());
		childtest.log(Status.INFO, "TaxPrice   :"+TaxPrice.getText());

		Assert.assertEquals(ttp, pp + sp + tp, ttp);

		Assert.assertEquals(SUBTOTAL.getText(), "SUBTOTAL**:");
		Assert.assertEquals(SHIPPING.getText(), "SHIPPING**:");
		Assert.assertEquals(TAXES.getText(), "TAXES:");
		Assert.assertEquals(TOTAL.getText(), "TOTAL");
		Assert.assertEquals(AmountWOVat.getText(), "** Amounts without GST");
		childtest.log(Status.INFO, "Total Price   :"+TotalPrice.getText());
	}
	
	public void ReturnHome() {
		
		childtest.log(Status.INFO, "Return To Home");
		BackToShop.click();
	}
	
}
