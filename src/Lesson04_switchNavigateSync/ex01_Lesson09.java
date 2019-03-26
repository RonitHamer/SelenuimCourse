package Lesson04_switchNavigateSync;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ex01_Lesson09 
{
	WebDriver driver;

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver(); //opens Chorme browser via constructor
		driver.manage().window().maximize();
	}

	@Test
	public void Test1_ChromeDriver() 
	{
		driver.navigate().to("http://atidcollege.co.il/Xamples/ex_switch_navigation.html");
		driver.findElement(By.id("btnAlert")).click();
		Alert ShowAlert = driver.switchTo().alert();
		System.out.println(ShowAlert.getText());
		ShowAlert.accept();		
		assertEquals(driver.findElement(By.id("output")).getText(),("Alert is gone."),("Incorrect Alert MSG "));
	}

	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}