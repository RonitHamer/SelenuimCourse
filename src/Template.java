import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Template 
{
	WebDriver driver;
	WebDriver driver2;
	WebDriver driver3;

	@BeforeClass
	public void beforeStart() 
	{
		//key, value format
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Automation\\libs\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\Automation\\libs\\MicrosoftWebDriver.exe");
		driver = new ChromeDriver(); //opens Chorme browser via constructor
		driver2 = new FirefoxDriver();
		driver3 = new InternetExplorerDriver();//needs to "Enable secure mode"
		driver.manage().window().maximize();
	}
//	@Test //if no priority will run based on ABC
//	public void Test1_ChromeDriver() 
//	{
//		///add functionality
//		driver.navigate().to("https://www.imdb.com/");
//	}

	@Test
	public void Test2_FirefoxDriver() 
	{
		driver2.navigate().to("https://www.google.com");
		driver2.get("https://www.google.com");//get the path
	}
	
	@Test
	public void Test3_IE() 
	{
		driver3.navigate().to("https://www.google.com");
	}
	@AfterClass
	public void closeSession()
	{
		driver.quit();//		driver.quit(); leaves open processes ..
		driver2.quit();
		driver3.quit();
	}
}
