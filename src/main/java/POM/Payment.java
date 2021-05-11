package POM;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;

public class Payment extends SuperTestNG {

	@FindBy(xpath = "//a[@ng-click= 'orderInfo2.viewMethods.back()']")
	private WebElement GoBack;

	@FindBy(xpath = "//span[@ng-show='!orderInfo2.isArEditMode']")
	private WebElement CheckOut;

	@FindBy(xpath = "//div[@ng-show='!orderInfo2.noPaymentNeeded']//h2[@class='header']")
	private WebElement PaymentMode;

	@FindBy(xpath = "//translate[contains(text(), 'Bank Wire')]")
	private WebElement BankWire;

	@FindBy(xpath = "//translate[contains(text(), 'Bank 2')]")
	private WebElement essecom;

	@FindBy(xpath = "//translate[contains(text(), 'Credit Card / Debit Card Payment - (Bank 1)')]")
	private WebElement CCAvenue;

	@FindBy(xpath = "//div[@class='ng-scope bankAccounts']/h5")
	private WebElement PleaseTransfer;

	@FindBy(xpath = "(//div[contains(@ng-repeat, 'key, account')])[1]")
	private WebElement HDFCBank;

	@FindBy(xpath = "(//div[contains(@ng-repeat, 'key, account')])[2]")
	private WebElement SBIBank;

	@FindBy(xpath = "(//div[contains(@ng-repeat, 'key, account')])[3]")
	private WebElement AxisBank;
	
	@FindBy(xpath = "//h4")
	private WebElement OrderSummary;
	
	@FindBy(xpath = "(//div[@class='product-info-wrapper']/div/span)[1]")
	private WebElement ProductName;
	
	@FindBy(xpath = "(//div[@class='product-info']/span)[2]")
	private WebElement ProductPV;
	
	@FindBy(xpath = "(//div[@class='product-info']/span)[1]")
	private WebElement ProductCode;
	
	@FindBy(xpath = "(//div[contains(@class,'product-cost')]/span)[1]")
	private WebElement Qty;
	
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
	
	@FindBy(xpath = "//button[@ng-click='orderInfo2.viewMethods.next()']")
	private WebElement Continue;
	

	public Payment(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void GoBack() throws InterruptedException{
		Thread.sleep(5000);
		GoBack.click();
	}

	public void paymentfields() {
		
		childtest.log(Status.INFO, "Payment Page Fields");

		Assert.assertTrue(GoBack.isDisplayed());
		Assert.assertEquals(CheckOut.getText(), "CHECKOUT");
		Assert.assertEquals(PaymentMode.getText(), "PAYMENT MODE (SELECT ANY ONE)");

	}

	public void paymentbanks() throws InterruptedException {
		
		childtest.log(Status.INFO, "Payment Banks");
		
		Thread.sleep(5000);
		BankWire.click();System.out.println("Bank Wire ++++++++++++++++++++++++++++++S");
		Assert.assertEquals(HDFCBank.getText(),
				"1\nAccount Name: Unicity Health Private Limited\nAccount Number: 02392560001958\nIFSC Number: HDFC0000239\nSwift Code: HDFCINBBXXX\nFull Name of Bank: HDFC Bank\nBranch Address:\n239-Powai - Hiranandani,\nPrudential Building Ground Floor, Hiranandi Business Park,\nPowai, Mumbai\n400076\nMaharashtra");
		Assert.assertEquals(SBIBank.getText(),
				"2\nAccount Name: Unicity Health Private Limited\nAccount Number: 37020932720\nIFSC Number: SBIN0005778\nFull Name of Bank: SBI Bank\nBranch:\nMG Road");
		Assert.assertEquals(AxisBank.getText(),
				"3\nAccount Name: Unicity Health Private Limited\nAccount Number: 916020065486603\nIFSC Number: UTIB0001336\nFull Name of Bank: Axis Bank\nBranch:\nNAVRANGPURA");
	}
	
	public void Essecom() throws InterruptedException, IOException{
		childtest.log(Status.INFO, "<b><font color=green>Essecom Payment Page</font></b>");
		
		String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		childtest.pass(
				"<b><font color=red>"+"Screenshot of Essecom Payment Page" + "</font></b>",
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
	}
	
	public void CCAvenue() throws InterruptedException {
		
		childtest.log(Status.INFO, "<b><font color=green>Payment Page</font></b>");
		childtest.log(Status.INFO, " Payment CCAvenue");
		Thread.sleep(5000);
		CCAvenue.click();
		/*Assert.assertFalse(HDFCBank.isDisplayed());
		Assert.assertFalse(SBIBank.isDisplayed());
		Assert.assertFalse(AxisBank.isDisplayed());*/
	}
	
	public void summary() throws InterruptedException {
		
		childtest.log(Status.INFO, "<b><font color=green>Order Summary</font></b>");
		
		Thread.sleep(10000);
		Assert.assertEquals(OrderSummary.getText(), "ORDER SUMMARY");
		Assert.assertEquals(ProductName.getText(), productdetails.get("name"));
		Assert.assertEquals(ProductPV.getText(), productdetails.get("pv"));
		Assert.assertEquals(ProductCode.getText(), productdetails.get("itemcode"));
		Assert.assertEquals(Qty.getText().replace("Qty: ", ""), productdetails.get("qty"));
	
		float pp = Float.parseFloat(ProductPrice.getText().replace("₹", ""));
		float sp = Float.parseFloat(ShippingPrice.getText().replace("₹", ""));
		float tp = Float.parseFloat(TaxPrice.getText().replace("₹", ""));
		float ttp = Float.parseFloat(TotalPrice.getText().replace("₹", "").replace(",", ""));
		
		Assert.assertEquals(ttp, pp+sp+tp, ttp);
		
		childtest.log(Status.INFO, "Total Price   "+ttp);
		
		Assert.assertEquals(SUBTOTAL.getText(), "SUBTOTAL**:");
		Assert.assertEquals(SHIPPING.getText(), "SHIPPING**:");
		Assert.assertEquals(TAXES.getText(), "TAXES:");
		Assert.assertEquals(PVTOTAL.getText(), "PV TOTAL:");
		Assert.assertEquals(TOTAL.getText(), "TOTAL");
		Assert.assertEquals(AmountWOVat.getText(), "** Amounts without GST");
		Assert.assertEquals(TotalPV.getText(), productdetails.get("pv").replace("PV: ", ""));
		childtest.log(Status.INFO, "Total PV   "+TotalPV.getText());
		Continue.click();
	}
	
	public void retailsummary() throws InterruptedException {
		
		childtest.log(Status.INFO, "Retail Order Summary");
		
		Thread.sleep(10000);
		Assert.assertEquals(OrderSummary.getText(), "ORDER SUMMARY");
		Assert.assertEquals(ProductName.getText(), productdetails.get("name"));
		Assert.assertEquals(ProductCode.getText(), productdetails.get("itemcode"));System.out.println("RBABBABBABABBAB"+Qty.getText().replace("Qty: ", ""));System.out.println(productdetails.get("qty"));
		Assert.assertEquals(Qty.getText().replace("Qty: ", ""), productdetails.get("qty"));
	
		float pp = Float.parseFloat(ProductPrice.getText().replace("₹", "").replace(",", ""));
		float sp = Float.parseFloat(ShippingPrice.getText().replace("₹", ""));
		float tp = Float.parseFloat(TaxPrice.getText().replace("₹", ""));
		float ttp = Float.parseFloat(TotalPrice.getText().replace("₹", "").replace(",", ""));
		
		Assert.assertEquals(ttp, pp+sp+tp, ttp);
		
		Assert.assertEquals(SUBTOTAL.getText(), "SUBTOTAL**:");
		Assert.assertEquals(SHIPPING.getText(), "SHIPPING**:");
		Assert.assertEquals(TAXES.getText(), "TAXES:");
		Assert.assertEquals(TOTAL.getText(), "TOTAL");
		Assert.assertEquals(AmountWOVat.getText(), "** Amounts without GST");
		
		Continue.click();
	}

}
