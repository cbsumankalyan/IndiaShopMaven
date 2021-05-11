package POM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;

public class Login  extends SuperTestNG {
	
	@FindBy(xpath = "//div[contains(@onclick, 'gdpr')]")
	private WebElement CookieClose;
	
	@FindBy(xpath = "(//button[contains(@ng-click,'flagDropdown')])[1]")
	private WebElement Country;
	
	@FindBy(xpath = "//translate[text()='India']")
	private WebElement CountrySelect;
	
	@FindBy(xpath = "//select[@ng-model='app.selectedProvince']")
	private WebElement StateSelect;
	
	@FindBy(xpath = "//a[@data-dismiss='modal']")
	private WebElement OKState;
	
	@FindBy(xpath = "//a[@class='login-link']")
	private WebElement LoginClick;
		
	@FindBy(id = "username")
	private WebElement Username;
	
	@FindBy(id = "password")
	private WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement UserLogin;
	
	public Login(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void SelectState() throws InterruptedException{
		Thread.sleep(10000);
		
		if(userdata.get("platform") == "LIVE") {
			CookieClose.click();
		}
		Country.click();
		CountrySelect.click();
		Select select = new Select(StateSelect);
		select.selectByVisibleText("Karnataka");
	}
	
	public void UserLogin(String username, String password) throws InterruptedException, IOException{
		childtest.log(Status.INFO, "<b><font color=green>Login Page</font></b>");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='background']")));
		Thread.sleep(10000);
		
		if(userdata.get("platform") == "LIVE") {
			CookieClose.click();
		}
		Country.click();
		childtest.log(Status.INFO, "Select India market");
		CountrySelect.click();
		childtest.log(Status.INFO, "Checked selected Country");
		Select select = new Select(StateSelect);
		select.selectByVisibleText(getTranslation(username));
		if (getTranslation(username).equals("Andaman and Nicobar Islands")){
			OKState.click();
		}
		
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='background']")));
		Thread.sleep(10000);
		LoginClick.click();
		
		Username.sendKeys(username);
		Password.sendKeys(password);
		UserLogin.click();
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='background']")));
		
		childtest.log(Status.INFO, "<b><font color=green>"+username +"   |   "+password+"</font></b>");
		childtest.log(Status.INFO, "Check User Details in Menu");
		userdata.put("id", username);
	}
}
