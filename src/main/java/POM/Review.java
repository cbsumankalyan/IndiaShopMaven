package POM;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;


public class Review extends SuperTestNG {

	@FindBy(xpath = "//translate[text()='GO BACK']")
	private WebElement GoBack;

	@FindBy(xpath = "//span[@ng-show='!review.isArEditMode']")
	private WebElement CheckOut;

	@FindBy(xpath = "//span[contains(@ng-show,'shipping.method.type!==')]")
	private WebElement ShippingInformation;

	@FindBy(xpath = "//translate[text() = 'Contact Information']")
	private WebElement ContactInformation;

	@FindBy(xpath = "//translate[text() = 'Payment Information']")
	private WebElement PayemntInformation;

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

	@FindBy(xpath = "(//div[@class='product-info']/span[@class='ng-binding'])[1]")
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

	@FindBy(xpath = "//button[@href='#/cart']")
	private WebElement ModifyItems;

	@FindBy(xpath = "//button[@ng-click='review.submitOrder()']/translate[text()='Submit Order']")
	private WebElement Continue;
	
	@FindBy(xpath = "//h4[@class='review-h3-def']//button[@class='btn-update']")
	private WebElement UpdateShipping;
	
	@FindBy(id = "shippingStreet1")
	private WebElement Street1;
	
	@FindBy(id = "shippingStreet2")
	private WebElement Street2;
	
	@FindBy(id = "phone")
	private WebElement Phone;
	
	@FindBy(id = "email")
	private WebElement Email;
	
	@FindBy(xpath = "//h4[@class='review-h3']//button[@ui-sref='orderInfo']")
	private WebElement UpdateContact;
	
	@FindBy(xpath = "//h4[@class='review-h3']//button[@ui-sref='orderInfo2']")
	private WebElement UpdatePayment;
	
	@FindBy(xpath = "//button[@ng-click='orderInfo.nextPage()']")
	private WebElement CheckOutContinue;

	public Review(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void review() {

		childtest.log(Status.INFO, "Review Details");
		
		Assert.assertTrue(GoBack.isDisplayed());
		Assert.assertEquals(ShippingInformation.getText(), "SHIPPING INFORMATION");
		Assert.assertEquals(ContactInformation.getText(), "CONTACT INFORMATION");
		Assert.assertEquals(PayemntInformation.getText(), "PAYMENT INFORMATION");
		Assert.assertEquals(CheckOut.getText(), "CHECKOUT");
		Assert.assertEquals(ReviewOrder.getText(), "REVIEW ORDER");

		Assert.assertTrue(ModifyItems.isDisplayed());
	}

	public void shipping(String username) throws IOException {
		childtest.log(Status.INFO, "Review Shipping Details");
		Assert.assertEquals(Shipping.getText().toLowerCase(),
				"shipping information update\n"+getTranslation(username+"Name").toLowerCase()+"\n"+getTranslation(username+"Address").toLowerCase());
	}
	
	public void retailshipping() {
		childtest.log(Status.INFO, "Review Retail Shipping Details");
		Assert.assertEquals(Shipping.getText(),
				"SHIPPING INFORMATION Update\n"+userdata.get("fname") +" "+ userdata.get("lname")+"\n23/2 2nd floor Khandari ParcHaudin Road\nBanglaore, KA, 560042, IN");
	}
	
	public void updateshippingaddress() {
		childtest.log(Status.INFO, "Update Shipping Details");
		Assert.assertEquals(Shipping.getText(),
				"SHIPPING INFORMATION Update\nIndia Training\n23/2 2nd floor Khandari Parc Haudin Road\nBangalore, KA, 560042, IN");
	}
	
	public void updateretailshippingaddress() {
		childtest.log(Status.INFO, "Update Retail Shipping Details");
		Assert.assertEquals(Shipping.getText(),
				"SHIPPING INFORMATION Update\n"+userdata.get("fname")+" "+userdata.get("lname")+"\n23/2 2nd floor Khandari Parc Haudin Road\nBanglaore, KA, 560042, IN");
	}
	
	public void contact(String username) throws IOException {
		childtest.log(Status.INFO, "Contact Details");
		Assert.assertEquals(Contact.getText().toLowerCase(),
				"contact information update\nphone: "+getTranslation(username+"Phone")+"\nemail: "+getTranslation(username+"Email").toLowerCase());
	}
	
	public void retailcontact() {
		childtest.log(Status.INFO, "Retail Contact Details");
		Assert.assertEquals(Contact.getText(),
				"CONTACT INFORMATION Update\nPhone: "+userdata.get("phone")+"\nEmail: "+userdata.get("email"));
	}
	
	public void updatecontactdetails() {
		childtest.log(Status.INFO, "Update Contact Details");
		Assert.assertEquals(Contact.getText(),
				"CONTACT INFORMATION Update\nPhone: 9019185440\nEmail: suman.cb@unicity.com");
	}

	public void payment() {
		childtest.log(Status.INFO, "Payment Type Bank Wire");
		Assert.assertEquals(Payment.getText(), "PAYMENT INFORMATION Update\nPayment Type: BankWire");
	}
	
	public void ccavenue() {
		childtest.log(Status.INFO, "Payment Type CC Avenue");
		Assert.assertEquals(Payment.getText(), "PAYMENT INFORMATION Update\nPayment Type: TppKtkRedirect::CCAvenue");
	}

	public void Orders() throws InterruptedException {
		childtest.log(Status.INFO, "<b><font color=green>Review Order Details</font></b>");
		
		Thread.sleep(10000);
		Assert.assertEquals(ProductName.getText(), productdetails.get("name"));
		Assert.assertEquals(ProductCode.getText(), productdetails.get("itemcode"));
//		Assert.assertEquals(PPPrice.getText().trim(), productdetails.get("price") + "TaxIncluded");
		Assert.assertEquals(Qty.getText().replace("Qty: ", ""), productdetails.get("qty"));
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
		childtest.log(Status.INFO, TotalPV.getText());
		childtest.log(Status.INFO, TotalPrice.getText());
		Continue.click();Thread.sleep(10000);
	}
	
	public void RetailOrders() throws InterruptedException {
		childtest.log(Status.INFO, "Retail Order Details");
		Thread.sleep(10000);
		Assert.assertEquals(ProductName.getText(), productdetails.get("name"));
		Assert.assertEquals(ProductCode.getText(), productdetails.get("itemcode"));
//		Assert.assertEquals(PPPrice.getText().trim(), productdetails.get("price") + "TaxIncluded");
		Assert.assertEquals(Qty.getText().replace("Qty: ", ""), productdetails.get("qty"));
		float pp = Float.parseFloat(ProductPrice.getText().replace("₹", "").replace(",", ""));
		float sp = Float.parseFloat(ShippingPrice.getText().replace("₹", ""));
		float tp = Float.parseFloat(TaxPrice.getText().replace("₹", ""));
		float ttp = Float.parseFloat(TotalPrice.getText().replace("₹", "").replace(",", ""));

		Assert.assertEquals(ttp, pp + sp + tp, ttp);
		Assert.assertEquals(SUBTOTAL.getText(), "SUBTOTAL**:");
		Assert.assertEquals(SHIPPING.getText(), "SHIPPING**:");
		Assert.assertEquals(TAXES.getText(), "TAXES:");
		Assert.assertEquals(TOTAL.getText(), "TOTAL");
		Assert.assertEquals(AmountWOVat.getText(), "** Amounts without GST");

		Continue.click();
	}

	public void updateshipping() throws InterruptedException{
		childtest.log(Status.INFO, "Update Shipping");
		Thread.sleep(5000);
		UpdateShipping.click();
		Street1.clear();
		Street2.clear();
		
		Street1.sendKeys("23/2 2nd floor Khandari Parc");
		Street2.sendKeys("Haudin Road");
		
		CheckOutContinue.click();
	}
	
	public void updatecontact() throws InterruptedException{
		childtest.log(Status.INFO, "Update Contact");
		Thread.sleep(5000);
		UpdateContact.click();
		Phone.clear();
		Email.clear();
		
		Phone.sendKeys("9019185440");
		Email.sendKeys("suman.cb@unicity.com");
		
		CheckOutContinue.click();
		
	}
	
	public void updatepayment() throws InterruptedException{
		childtest.log(Status.INFO, "Update Payment");
		Thread.sleep(10000);
		UpdatePayment.click();
	}
	
	public void goback() throws InterruptedException{
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", GoBack);
		GoBack.click();
		childtest.log(Status.INFO, "Go Back");
	}
}
