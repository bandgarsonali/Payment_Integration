package com.payments.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static ReadConfigProperties readconfig = new ReadConfigProperties();

	protected static WebDriver driver;
	public static Logger logger;
	public static String baseurl;
	public static String userName;
	public static String password;
	public static String browser;
	public ExtentSparkReporter spark;
	public static String filename;
	public File file;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;

	@BeforeClass
	public static void driversetup() throws IOException {
		baseurl = readconfig.getBaseUrl();
		browser = readconfig.setBrowser();

		logger = Logger.getLogger("Payments");
		PropertyConfigurator.configure("Log4j.propertise");

		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(".\\Resource\\Prop.properties");
		obj.load(objfile);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(baseurl);
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("fission.bfcacheInParent", false);
			profile.setPreference("fission.webContentIsolationStrategy", 0);

			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			driver = new FirefoxDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(baseurl);
		}

		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(baseurl);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
	}

	public void handleAlert() {
		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static String getScreenShot(String TestCasename, WebDriver driver) throws Exception {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		String TestStamp = new SimpleDateFormat("yyyy-mm-dd-hh-ms-ss").format(new Date());

		File Src = scrShot.getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") + "//Reports//" + TestCasename + "-" + TestStamp + ".png");
		FileUtils.copyFile(Src, Dest);
		return System.getProperty("user.dir") + "//Reports//" + TestCasename + "-" + TestStamp + ".png";
	}

	
	public static void scrollToElement(WebElement ele3, WebDriver driver) {
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].scrollIntoView();", ele3);
	}

	public void scrollToElementAndClick(WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(500);
		element.click();
	}

	public void selectByVisibleText(WebElement el, String text, WebDriver driver) {
		Select drpState = new Select(el);
		drpState.selectByVisibleText(text);
	}

	//@AfterClass
	//public void closedriver() throws IOException {
		//driver.quit();
		//extent.flush();
		// Desktop.getDesktop().browse(file.toURI());
	//}
}
