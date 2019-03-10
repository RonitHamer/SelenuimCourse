package Lesson01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelenuimWebDriver 
{
	@BeforeMethod
	public void beforeStart() 
	{
		String Title="IMDB";
		String URL="https://www.imdb.com/";
	}
	@Test
	public void f() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.imdb.com/");
		String URL=driver.getCurrentUrl();
		driver.navigate().refresh(); 
		driver.quit(); 
	}
}
