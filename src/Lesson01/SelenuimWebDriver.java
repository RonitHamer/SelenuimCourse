package Lesson01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//ex of class_04 - Selenium WebDriver- Drivers and Webdriver Object Methods.pptx
public class SelenuimWebDriver 
{
	private WebDriver driver;

	String expectedTitle = "Ratings and Reviews for New Movies and TV Shows - IMDb";
	String expectedURL ="https://www.imdb.com/";	

	@BeforeClass
	public void openBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();//needs to be global
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		Thread.sleep(1000);
	}

	@Test (priority = 2, enabled=false) 
	public void Test1()  
	{
		driver.get("https://www.imdb.com");
		driver.navigate().refresh();			
		String actualTitle=driver.getTitle();
		System.out.println("Title is:" + actualTitle);
		String actualURL = driver.getCurrentUrl();
		System.out.println("Address is:" + actualURL);

		if (actualTitle.equals(expectedTitle))
			System.out.println("Title test Passed");
		else
			System.out.println("Title test Failed");

		if (actualURL.equals(expectedURL))
			System.out.println("Address test Passed");
		else
			System.out.println("Address test Failed");

		//		assertEquals(actualTitle,expectedTitle,"Title Test Failed");
		//		assertEquals(actualURL,actualURL,"URL Test Failed");
	}

	@Test
	public void Test2() 
	{
		driver.get("https://www.google.com/");
		driver.get("https://www.bing.com/");	
		driver.navigate().back();
		System.out.println("GoogleTitle is: " + driver.getTitle());	
		String Source = driver.getPageSource();
		if (Source.contains("Bubble"))
			System.out.println("Bubble Exists");
		else
			System.out.println("Bubble Not Exists");
	}
	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}
