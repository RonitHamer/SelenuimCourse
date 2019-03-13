import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Template 
{
	WebDriver driver;

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test //if some tests will run based on ABC
	public void f() 
	{
		///add functionality
		driver.navigate().to("https://www.imdb.com/");
	}

	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}
