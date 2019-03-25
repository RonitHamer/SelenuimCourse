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
	private WebDriver driver;
	String expectedTitle = "Ratings and Reviews for New Movies and TV Shows - IMDb";
	String expectedURL ="https://www.imdb.com/";	

	@BeforeClass
	public void openBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();//needs to be global
		driver.manage().window().maximize();
		driver.get("https://www.imdb.com");
	}

	@Test
	public void Test1() 
	{
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

		@AfterClass
		public void closeSession()
		{
			driver.quit();
		}
}
