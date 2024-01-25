package com.payments.pageobjects;
import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.payments.utils.ReadConfigProperties;

public class App_Form {
	
	WebDriver ldriver;
	ReadConfigProperties readconfig= new com.payments.utils.ReadConfigProperties();

	public App_Form(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//*[@id='navbar-menu']/a") WebElement Click;
	@FindBy(id="form1") WebElement Name;
	@FindBy(id="form2") WebElement Email;
	@FindBy(id="form3") WebElement Password;
	@FindBy(id="form4") WebElement RepeatPassword;
	@FindBy(className="btn") WebElement RegisterButton;

	public WebDriver getLdriver() {
	return ldriver;
	}
	public void setLdriver(WebDriver ldriver) {
	this.ldriver = ldriver;
	}
	public ReadConfigProperties getReadconfig() {
	return readconfig;
	}
	public void setReadconfig(ReadConfigProperties readconfig) {
	this.readconfig = readconfig;
	}
	public WebElement getClick() {
		return Click;
	}
	public void setClick(WebElement click) {
		Click = click;
	}
	public WebElement getName() {
	return Name;
	}
	public void setName(String name) {
	Name.sendKeys(name);
	}
	public WebElement getEmail() {
	return Email;
	}
	public void setEmail(String email) {
	Email.sendKeys(email);
	}
	public WebElement getPassword() {
	return Password;
	}
	public void setPassword(String password) {
	Password.sendKeys(password);
	}
	public WebElement getRepeatPassword() {
	return RepeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
	RepeatPassword.sendKeys(repeatPassword);
	}
	public WebElement getRegisterButton() {
	return RegisterButton;
	}
	public void setRegisterButton(WebElement registerButton) {
	RegisterButton = registerButton;
	}
	/*public void setRepeatPassword(String trim) {
	// TODO Auto-generated method stub

	}
	public void setPassword(String trim) {
	// TODO Auto-generated method stub

	}
	public void setEmail(String trim) {
	// TODO Auto-generated method stub

	}
	public void setName(String trim) {
	// TODO Auto-generated method stub

	}
	*/

	}

	/*

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://payment-sample-ui.s3-website.ap-south-1.amazonaws.com/home");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//Login Button
		driver.findElement(By.xpath("//*[@id='navbar-menu']/a")).click();
		/*
		//Registration Button
		driver.findElement(By.className("btn-link")).click();
		
		
		//Registration Details
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("form1")).sendKeys("Sonali");
		driver.findElement(By.id("form2")).sendKeys("sonaliban@infinite.com");
		driver.findElement(By.id("form3")).sendKeys("Sonali@0512");
		driver.findElement(By.id("form4")).sendKeys("Sonali@0512");
		driver.findElement(By.className("btn")).click();
		
		// Login Page
		driver.findElement(By.id("email")).sendKeys("sonali.bandgar@infinite.com");
		driver.findElement(By.id("password")).sendKeys("Sonali@0510");
		driver.findElement(By.className("btn")).click();
		
		//Place Order
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@id=\"navbar-menu\"]/div/a[2]")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.findElement(By.xpath("//*[@id=\"storeFront\"]/div/div/div/div[1]/div/div[2]/div[3]/button")).click();
		//driver.findElement(By.xpath("//button[text()='Add To Cart'][0]")).click();
		
		
		Thread.sleep(700);
		
		List<WebElement> store_items = driver.findElements(By.xpath("//div[@class='storeItemDisplay_card__Id1k7']/div[@class='card-content']/div/div/div[1]"));
		for(int i=0;i<store_items.size();i++)
		{
		
			
			String title=store_items.get(i).getText();
			if(title.equals("StarKist's Chunk Light Tuna"))
			{
				System.out.println( store_items.get(i).getText());
				
				WebElement element1=store_items.get(i).findElement(By.xpath("//div[@class='storeItemDisplay_cardRow2__sSxXO']/div[3]/button"));
				//JavascriptExecutor js3 = (JavascriptExecutor) driver;
				//js3.executeScript("arguments[0].scrollIntoView();", element);
				//Thread.sleep(700);
				
				JavascriptExecutor js4 = (JavascriptExecutor) driver;
				js4.executeScript("arguments[0].scrollIntoView();", element1);
				Thread.sleep(600);
				js4.executeScript("arguments[0].click();", element1);
				
				
				//Thread.sleep(600);
				//element1.click();
				
				


				
				//element.click();
				
				//JavascriptExecutor js4= (JavascriptExecutor) driver;
				//js4.executeScript("arguments[0].scrollIntoView();", element1);
				//element1.click();
				//store_items.get(i).findElement(By.xpath("//div[@class='storeItemDisplay_cardRow2__sSxXO']/div[3]/button")).click();
			}
			
			
		}
		
		
		/*Try2 :
	
		
		/*List<WebElement> button_elements=driver.findElements(By.xpath("//div[@class='storeItemDisplay_cardRow2__sSxXO']/div[3]/button"));
		for(int i=0;i<button_elements.size();i++)
		{
			button_elements.get(i).click();
			break;
		}
		
		//Checkout Item 
		
		driver.findElement(By.xpath("//*[@id=\"navbar-menu\"]/div/a[4]/p")).click();
		Thread.sleep(1000);
		WebElement checkout_item=driver.findElement(By.xpath("//*[@id='cart']/div/div/div/div[1]/div[2]/div/div/button[1]"));
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("arguments[0].scrollIntoView();", checkout_item);
		Thread.sleep(600);
		js4.executeScript("arguments[0].click();", checkout_item);
		//checkout_item.click();
		
		//Select Payment Gateway
		
		List<WebElement> payments_list = driver.findElements(By.xpath("//*[@id=\"gatewaySelection\"]/option"));
		
		for(int i=0;i<payments_list.size();i++)
		{
		
			
			String title=payments_list.get(i).getText();
			if(title.equals("CommerceHub"))
			{
				System.out.println( payments_list.get(i).getText());
				Select title1 = new Select(driver.findElement(By.id("gatewaySelection")));
				title1.selectByVisibleText("CommerceHub");
				
				
			}
		}
		
		//Enter Card Details
		driver.findElement(By.id("cardNumber")).sendKeys("4111 1111 1111 1111");
		driver.findElement(By.id("cardDate")).sendKeys("12/25");
		driver.findElement(By.id("cvv")).sendKeys("198");
		WebElement pay_button=driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[4]/button[1]"));
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].scrollIntoView();", pay_button);
		Thread.sleep(600);
		js5.executeScript("arguments[0].click();", pay_button);
		 
		
		
	}
}
*/
