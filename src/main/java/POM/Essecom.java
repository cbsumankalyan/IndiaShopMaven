package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;


public class Essecom extends SuperTestNG {
	
	@FindBy(id = "name")
	private WebElement Name;
	
	@FindBy(id = "contactNo")
	private WebElement Contact;
	
	@FindBy(id = "mobileNo")
	private WebElement Mobile;
	
	@FindBy(id = "email")
	private WebElement Email;
	
	@FindBy(xpath = "//select[@id='select_payment_mode']")
	private WebElement SelectPayment;
	
	@FindBy(xpath = "//select[@id='credit_card_type']")
	private WebElement SelectCardType;
	
	@FindBy(id = "credit_card_no")
	private WebElement CCNumber;
	
	@FindBy(id = "credit_card_name")
	private WebElement CCName;
	
	@FindBy(id = "credit_expiry_mm")
	private WebElement CCMonth;
	
	@FindBy(id = "credit_expiry_yyyy")
	private WebElement CCYear;
	
	@FindBy(id = "credit_cvv_no")
	private WebElement CVV;
	
	@FindBy(id = "captcha_image")
	private WebElement Captcha;
	
	@FindBy(id = "captchaUser")
	private WebElement CaptchaText;
	
	@FindBy(xpath = "//input[@value='Cancel']")
	private WebElement Cancel;
	
	@FindBy(xpath = "//span[@ng-bind-html='alert.msg']")
	private WebElement ErrorMsg;
	
	public Essecom(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void payment() throws InterruptedException{
		
		childtest.log(Status.INFO, "Essecom Payment");
		
		Thread.sleep(30000);
		Assert.assertEquals("https://payment.essecom.com/PaymentGateway/Payment.jsp", driver.getCurrentUrl());
		
		Name.sendKeys("C B Suman");
		Contact.sendKeys("9019185440");
		Mobile.sendKeys("9019185440");
		Email.sendKeys("cbsumankalyan@gmail.com");
		
		Select select =  new Select(SelectPayment);
		select.selectByVisibleText("CreditCard");
		
		
		Select selectcard =  new Select(SelectCardType);
		selectcard.selectByVisibleText("Visa");
		
		CCNumber.sendKeys("4111111111111111");
		CCName.sendKeys("C B Suman");
		CCMonth.sendKeys("10");
		CCYear.sendKeys("2021");
		CVV.sendKeys("123");
		CaptchaText.sendKeys(Captcha.getText());
		Cancel.click();
		
	}
	
}
