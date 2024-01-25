package com.payments.testcase;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.payments.pageobjects.App_Form;
import com.payments.utils.BaseClass;
import com.payments.utils.ExcelDataProvider;


public class Pay_Workflow extends BaseClass{

	WebDriver driver;
	BaseClass bs=new BaseClass();
	
	
	@DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws Exception {
		Object[][] arrObj= ExcelDataProvider.getExcelData(".\\Resource\\TestData.xlsx","TestData");
        return arrObj;
	}	
	

	@Test(dataProvider = "excelData")
	public void Enrollment(String Name, String Email, String Password,String RepeatPassword) throws IOException, InterruptedException {
		this.driver=BaseClass.driver;
		App_Form pg=new App_Form(driver);
		//Registration
		pg.getClick();
		pg.setName(Name.trim());
		pg.setEmail(Email.trim());
		pg.setPassword(Password.trim());
		pg.setRepeatPassword(RepeatPassword.trim());
		/*
		pg.setCityName(CityName.trim());
		WebElement eleSel=pg.getselectStateName();
		bs.selectByVisibleText(eleSel, State, driver);
		pg.setpostalCode(postalCode);		
		WebElement elphonetype=pg.getSelPhoneType();
		bs.selectByVisibleText(elphonetype, PhoneType.trim(), driver);
		pg.setPhoneNumberInput(PhoneNumber.trim());
		pg.setExtension(Extension.trim());
		pg.setEmailId(EmailId.trim());
		pg.setReEnterEmailId(ReEmailId.trim());
		String dl=DriverLicense;
		Integer dlint=Integer.parseInt(dl);
		DriverLicense=(dlint).toString();
		pg.setDriverLicense(DriverLicense.trim());
		pg.setReEnterDriverLicense(ReDriverLicense.trim());
		WebElement eledlstate=pg.getSelDlStateID();
		bs.selectByVisibleText(eledlstate, DlState, driver);
		pg.setDlExpiryDate(DlExpiryDate);
		pg.setDateOfBirth(DateOfBirth);
		
		WebElement ele= pg.getBtnLinkAccount();
		bs.scrollToElementAndClick(ele, driver);
		pg.clickAcceptTermsChk();
		Thread.sleep(500);
		ele.click();
		Thread.sleep(1000);		
		pg.getOpenAccountWidget().click();
		Thread.sleep(700);	
		driver.findElement(By.id("searchbar")).sendKeys("CashEdge");
		Thread.sleep(700);
		driver.findElement(By.xpath("//div[@id='ul-div-id-2']/div[2]/p")).click();
		Thread.sleep(700);
		driver.findElement(By.xpath("//input[@id='acctForm:j_idt147:0:login_']")).sendKeys("nonmfa1234");
		driver.findElement(By.xpath("//input[@id='acctForm:j_idt151:0:password_']")).sendKeys("nonmfa1234");
		scrollToElement(driver.findElement(By.xpath("//a[@id='acctForm:FiNext1']")), driver);
		Thread.sleep(700);
		driver.findElement(By.xpath("//a[@id='acctForm:FiNext1']")).click();
		
		//driver.findElement(By.xpath("//input[@id='acctForm:FiNext1']")).click();	
		
		WebElement accchk=driver.findElement(By.id("acctForm:selectAccount:1"));
		WebDriverWait waitchk=new WebDriverWait(driver, Duration.ofSeconds(60));
		waitchk.until(ExpectedConditions.elementToBeClickable(accchk));
		
		driver.findElement(By.id("acctForm:selectAccount:1")).click();
		Thread.sleep(100);
		driver.findElement(By.id("acctForm:AddNext")).click();
		
		WebElement elewinow = driver.findElement(By.id("submitButton"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(elewinow));
		
		driver.findElement(By.id("returnToEnrollment")).click();
				
		WebElement ele2=pg.getbtnAcceptandSignIn();
		BaseClass.scrollToElement(ele2, driver);
		
		Thread.sleep(700);
		
		pg.clickAcceptTermsChk();
		ele2.click();	
		*/
	}	
}
