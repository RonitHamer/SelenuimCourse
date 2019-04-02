package Lesson05_ErrHandeling;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ex01_Lesson11_errHandel 
{
	WebDriver driver;

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://atidcollege.co.il/Xamples/ex_synchronization.html");
		driver.manage().window().maximize();
	}

	@Test
	public void Test1_errorHandel()
	{		
		try
		{
			driver.findElement(By.id("btn")).click();
			Thread.sleep(10000);
			driver.findElement(By.id("checkbox")).isDisplayed();
		}
		catch (Exception e)
		{
			System.out.println(e); //noSuchElement 

		}
	}

	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}

}
