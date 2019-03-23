package Lesson03_controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ControllersEx 
{
	WebDriver driver;

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://atidcollege.co.il/Xamples/ex_controllers.html");
		driver.manage().window().maximize();
	}
	@Test 
	public void Test1_ChromeDriver() 
	{
		///add functionality
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys("Ronit"); 
		System.out.println(driver);
		//String URL= driver.getCurrentUrl();
	}

	@AfterClass
	public void closeSession()
	{
//		System.out.println(driver.findElement(By.linkText("About")));
		//driver.quit();
	}
}
