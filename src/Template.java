import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Template 
{
	WebDriver driver;
	WebDriver driver2;
	
	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Automation\\libs\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriver driver2 = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@Test //if no priority will run based on ABC
	public void Test1_ChromeDriver() 
	{
		///add functionality
		driver.navigate().to("https://www.imdb.com/");
	}
	
	@Test
	public void Test2_FirefoxDriver() 
	{
		///add functionality
		driver2.navigate().to("https://www.ynet.com/");
	}

	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}
