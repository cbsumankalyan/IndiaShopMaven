package Pages;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SuperTestNG {

	public static WebDriver driver;
		
	public static SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
	public static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	protected String getTranslation(String value) throws IOException {

		Properties p = new Properties();
		p.load(new FileReader("C:/Users/sumancb/git/IndiaShop/India/src/test/java/property/catalog.properties"));
		return p.getProperty(value);
	}
	

	public static String[] qty = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10+" };
	public static String[] allproducts = { "ACTIVATE (30 SACHETS)", "BALANCE (30 SACHETS)", "BIOS LIFE COFFEE MIX (30 SACHETS)", "BIOS LIFE SLIM (30 SACHETS)", "BIOSLIFE AIR", "BLENDER BOTTLE W/AGITATOR", "CALCIUM MAGNESIUM COMPLEX (30 SACHETS)",
			"CLEAR START KIT - LIFIBER (30 SACHETS)+NATURE'S TEA (30 SACHETS)+PARAWAY PLUS (150 CAPSULES)", "ENRICH (500 GMS)", "KIDDO (16 SACHETS)", "LC BASE (20 SACHETS)", "LEAN COMPLETE (25 SACHETS)", "LIFIBER (28 SACHETS)", "NATURE'S TEA (30 SACHETS)",
			"NEIGENE COLLAGEN PLUS (30 SACHETS)", "PARAWAY PLUS (150 CAPSULES)", "PIN UNICITY LAPEL IN", "PREMIUM MATCHA (10 SACHETS)",
			"PREMIUM SUPER CHLOROPHYLL (45 SERVINGS)", "SUPER CHLOROPHYLL PACK", "UNICITY CATALOGUE IN", "UNICITY FAMILY PACK"};
	public static String[] products = { "ACTIVATE (30 SACHETS)", "BALANCE (30 SACHETS)", "BIOS LIFE COFFEE MIX (30 SACHETS)", "BIOS LIFE SLIM (30 SACHETS)", "BIOSLIFE AIR", "CALCIUM MAGNESIUM COMPLEX (30 SACHETS)",
			"CLEAR START KIT - LIFIBER (30 SACHETS)+NATURE'S TEA (30 SACHETS)+PARAWAY PLUS (150 CAPSULES)", "ENRICH (500 GMS)", "KIDDO (16 SACHETS)", "LC BASE (20 SACHETS)", "LEAN COMPLETE (25 SACHETS)", "LIFIBER (28 SACHETS)", "NATURE'S TEA (30 SACHETS)",
			"NEIGENE COLLAGEN PLUS (30 SACHETS)", "PARAWAY PLUS (150 CAPSULES)", "PREMIUM MATCHA (10 SACHETS)",
			"PREMIUM SUPER CHLOROPHYLL (45 SERVINGS)", "SUPER CHLOROPHYLL PACK", "UNICITY CATALOGUE IN", "UNICITY FAMILY PACK"};
	public static String[] accessories = { "BLENDER BOTTLE W/AGITATOR", "PIN UNICITY LAPEL IN" };
	
	public static String[] retailallproducts = {"ACTIVATE (30 SACHETS)", "BALANCE (30 SACHETS)", "BIOS LIFE COFFEE MIX (30 SACHETS)", "BIOS LIFE SLIM (30 SACHETS)", "BIOSLIFE AIR", "BLENDER BOTTLE W/AGITATOR", "CALCIUM MAGNESIUM COMPLEX (30 SACHETS)",
			"CLEAR START KIT - LIFIBER (30 SACHETS)+NATURE'S TEA (30 SACHETS)+PARAWAY PLUS (150 CAPSULES)", "ENRICH (500 GMS)", "KIDDO (16 SACHETS)", "LC BASE (20 SACHETS)", "LEAN COMPLETE (25 SACHETS)", "LIFIBER (28 SACHETS)", "NATURE'S TEA (30 SACHETS)",
			"NEIGENE COLLAGEN PLUS (30 SACHETS)", "PARAWAY PLUS (150 CAPSULES)", "PREMIUM MATCHA (10 SACHETS)",
			"PREMIUM SUPER CHLOROPHYLL (45 SERVINGS)"};
	public static String[] retailproducts = { "ACTIVATE (30 SACHETS)", "BALANCE (30 SACHETS)", "BIOS LIFE COFFEE MIX (30 SACHETS)", "BIOS LIFE SLIM (30 SACHETS)", "BIOSLIFE AIR", "CALCIUM MAGNESIUM COMPLEX (30 SACHETS)",
			"CLEAR START KIT - LIFIBER (30 SACHETS)+NATURE'S TEA (30 SACHETS)+PARAWAY PLUS (150 CAPSULES)", "ENRICH (500 GMS)", "KIDDO (16 SACHETS)", "LC BASE (20 SACHETS)", "LEAN COMPLETE (25 SACHETS)", "LIFIBER (28 SACHETS)", "NATURE'S TEA (30 SACHETS)",
			"NEIGENE COLLAGEN PLUS (30 SACHETS)", "PARAWAY PLUS (150 CAPSULES)", "PREMIUM MATCHA (10 SACHETS)",
			"PREMIUM SUPER CHLOROPHYLL (45 SERVINGS)"};
	public static String[] retailaccessories = { "BLENDER BOTTLE W/AGITATOR"};
	
	public static Map<String, String> productdetails = new HashMap<String, String>();
	public static Map<String, String> userdata = new HashMap<String, String>();

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	
	public static ExtentTest Essecom;
	public static ExtentTest CCAvenue;	
	public static ExtentTest Retail;	
	public static ExtentTest BankWire;
	public static ExtentTest QACCAvenue;
	public static ExtentTest QARetail;
	
	public static ExtentTest childtest;
	public static ExtentTest parenttest;

	@BeforeTest
	public void StartReport() {
	
	
		htmlReporter = new ExtentSparkReporter("C://xampp//htdocs//ShopReport//Shop-"+date.format(timestamp)+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		Essecom = extent.createTest("<b><font color=DE6449>"+"Essecom" + "</font></b>");
		CCAvenue = extent.createTest("<b><font color=DE6449>"+"CCAvenue" + "</font></b>");
		Retail = extent.createTest("<b><font color=DE6449>"+"Retail" + "</font></b>");
		BankWire = extent.createTest("<b><font color=DE6449>"+"BankWire" + "</font></b>");
		
		QARetail = extent.createTest("<b><font color=DE6449>"+"QA Retail" + "</font></b>");
		QACCAvenue = extent.createTest("<b><font color=DE6449>"+"QA CCAvenue" + "</font></b>");
	}

	@BeforeMethod
	public void PreConditon() throws ParseException, URISyntaxException, MalformedURLException {

		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("incognito");
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		if (this.getClass().getSimpleName().toString().equals("Essecom")) {
			driver.get("https://shop.unicity.com/#/home");
			userdata.put("platform", "LIVE");
		}
		
		if (this.getClass().getSimpleName().toString().equals("CCAvenue")) {
			driver.get("https://shop.unicity.com/#/home");
			userdata.put("platform", "LIVE");
		}
		
		if (this.getClass().getSimpleName().toString().equals("Retail")) {
			driver.get("https://shop.unicity.com/#/home");
			userdata.put("platform", "LIVE");
		}
		
		if (this.getClass().getSimpleName().toString().equals("BankWire")) {
			driver.get("https://shop.unicity.com/#/home");
			userdata.put("platform", "LIVE");
		}
		
		if (this.getClass().getSimpleName().toString().equals("QACCAvenue")) {
			driver.get("https://shop.unicityqa.com/master/#/home");
			userdata.put("platform", "QA");
		}
		
		if (this.getClass().getSimpleName().toString().equals("QARetail")) {
			driver.get("https://shop.unicityqa.com/master/#/home");
			userdata.put("platform", "QA");
		}
		
		
		
		
		
	}

	@AfterMethod
	public void PostCondition(ITestResult testResult) throws IOException {
		
		if (testResult.isSuccess()) {
			String logText = "<b>Test Method Successfull</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			childtest.log(Status.PASS, m);

		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			
			String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			String exceptionMessage = testResult.getThrowable().getMessage();
			
			
			childtest.fail("<details><summary><b><font color=red>Exception Occured click to see details:"
					+ "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
			childtest.fail(
					"<b><font color=red>"+"Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
			String logText = "<b>Test Method Failed</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			childtest.log(Status.FAIL, m);			
			driver.quit();

		} else if (testResult.getStatus() == ITestResult.SKIP) {
			childtest.log(Status.SKIP, "Test Skipped");
		}

		driver.quit();
	}

	@AfterSuite
	public void afterSuite() throws Exception {
		
		extent.flush();
		NoAttach.Sendmail();
	}

}
