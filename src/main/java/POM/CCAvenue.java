package POM;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;

public class CCAvenue extends SuperTestNG {

	@FindBy(id = "creditCardNumber")
	private WebElement CCNumber;

	@FindBy(xpath = "//select[@id='expiryMonthCreditCard']")
	private WebElement CCMonth;
	
	@FindBy(xpath = "//select[@id='netBankingBank']")
	private WebElement CCAvenue;

	@FindBy(id = "expiryYearCreditCard")
	private WebElement CCYear;

	@FindBy(id = "CVVNumberCreditCard")
	private WebElement CVV;

	@FindBy(id = "SubmitBillShip")
	private WebElement MakePayment;

	public CCAvenue(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void ccavenue() throws InterruptedException {

		childtest.log(Status.INFO, "<b><font color=green>CC Avenue Payment Page</font></b>");

		if (userdata.get("platform") == "LIVE") {

			Thread.sleep(5000);
			Assert.assertEquals("https://secure.ccavenue.com/transaction/transaction.do?command=initiateTransaction",
					driver.getCurrentUrl());
			childtest.log(Status.INFO, driver.getCurrentUrl());
			CCNumber.sendKeys("4111111111111111");
			Select select = new Select(CCMonth);
			select.selectByVisibleText("Dec (12)");
			CCYear.sendKeys("2021");
			CVV.sendKeys("123");
			MakePayment.click();
			childtest.log(Status.INFO, driver.getCurrentUrl());
			Assert.assertEquals("https://secure.ccavenue.com/transaction.do?command=retryTransaction",
					driver.getCurrentUrl());
			String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			childtest.pass(
					"<b><font color=red>"+"Screenshot of CC Avenue Payment Page" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
		} else {
			
			Thread.sleep(5000);
			Assert.assertEquals("https://test.ccavenue.com/transaction/transaction.do?command=initiateTransaction",
					driver.getCurrentUrl());
			childtest.log(Status.INFO, driver.getCurrentUrl());
			Select select = new Select(CCAvenue);
			select.selectByVisibleText("AvenuesTest");
			MakePayment.click();
			childtest.log(Status.INFO, driver.getCurrentUrl());
			Assert.assertEquals("https://test.ccavenue.com/bnk/servlet/processNbkReq?gtwID=AVN&requestType=PAYMENT",
					driver.getCurrentUrl());
			
			String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			childtest.pass(
					"<b><font color=red>"+"Screenshot of CC Avenue Payment Page" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
			
		}
		
		
		
	}

}
