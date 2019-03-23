package Lesson02_locators;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex01
{

	WebDriver driver;

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	@Test
	public void Element01_linktext() 
	{		
		driver.navigate().to("https://www.seleniumhq.org/");
		System.out.println(driver.findElement(By.linkText("About")));
	}
	
	//add id
	//add partial link
	//add tag a

	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}

