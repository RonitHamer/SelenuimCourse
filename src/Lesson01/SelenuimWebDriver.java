package Lesson01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//ex of class_04 - Selenium WebDriver- Drivers and Webdriver Object Methods.pptx
public class SelenuimWebDriver 
{
	 WebDriver driver;
	 
	@BeforeClass
	public void beforeStart() 
	{
		String Title="IMDB";
		String URL="https://www.imdb.com/";
		//assertEquals(Title, URL);
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver(); -- needs to be global
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void f() 
	{
		driver.navigate().to("https://www.imdb.com/");
		String URL=driver.getCurrentUrl();
		driver.navigate().refresh(); 
		driver.quit(); 

	}

	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}
