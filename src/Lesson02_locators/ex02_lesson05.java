package Lesson02_locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ex02_lesson05 

{
	static WebDriver driver;

	@BeforeClass
	static void StartSession()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
	}

	@Test
	public void Test1_ex02_lesson05() 
	{
		WebElement[] ElementsArray = 
			{
					driver.findElement(By.className("central-featured-logo")),
					driver.findElement(By.id("searchInput")),
					driver.findElement(By.id("searchLanguage")),
					//driver.findElement(By.className("footer-sidebar-text jsl10n")),
					driver.findElement(By.partialLinkText("Wikimedia Foundation"))
			};

		for (WebElement ele: ElementsArray)
		{
			System.out.println("Element is: " + ele);
		}

	}

	@AfterClass
	static void CloseSession()
	{
		driver.quit();
	}
}
