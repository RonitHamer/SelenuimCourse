package Lesson07_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageObject_Tests 
{

	WebDriver driver;
	PageObject_LoginPage startParam;
	PageObject_Form FormParam;

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://atidcollege.co.il/Xamples/webdriveradvance.html");		
		startParam = PageFactory.initElements(driver, PageObject_LoginPage.class);
		FormParam = PageFactory.initElements(driver, PageObject_Form.class);
	}
	@Test 
	public void Test01_login() 
	{
		startParam.username2.sendKeys("Selenium");
		startParam.password2.sendKeys("webdriver");
		startParam.submit.click();		//FormParam.
	}

	@Test 
	public void Test02_form() 
	{
		FormParam.occupation.sendKeys("QA");
		FormParam.age.sendKeys("40");
		FormParam.location.sendKeys("HodHaSharon");		
	}
	
	//Test03____FINISH()

	
	
	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}
