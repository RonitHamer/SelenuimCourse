package Lesson04_switchNavigateSync;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ex01_Lesson10Sync 
{
	WebDriver driver;

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver(); //opens Chorme browser via constructor
		driver.manage().window().maximize();
		driver.navigate().to("http://atidcollege.co.il/Xamples/ex_synchronization.html");
	}

	@Test
	public void Test1_rendered() 
	{
		driver.findElement(By.id("rendered")).click();
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h4"))); 
		System.out.println(driver.findElement(By.tagName("h4")).getText());
		assertEquals(driver.findElement(By.tagName("h4")).getText(),"My Rendered Element After Fact!","rendered btn failed to load");
	}
	
	@Test
	public void Test2_hidden() 
	{
		driver.findElement(By.id("hidden"));
	}
	
	@Test
	public void Test3_btn() 
	{
		driver.findElement(By.id("btn"));
	}


	@AfterClass
	public void closeSession()
	{
		driver.close();
	}
}
