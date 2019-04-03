package Lesson02_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ex01_lesson06
{
	public WebDriver driver;

	@BeforeClass
	public void StartSession() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://atidcollege.co.il/Xamples/ex_locators.html");
		Thread.sleep(1000);
	}

	@Test
	public void Test1_ex01_lesson06() 
	{

		WebElement element1_ID = driver.findElement(By.id("locator_id"));
		WebElement element2_name = driver.findElement(By.name("locator_name"));		
		WebElement element3_name = driver.findElement(By.tagName("p"));
		WebElement element4_classNname = driver.findElement(By.className("locator_class"));
		WebElement element5_linkText = driver.findElement(By.linkText("myLocator(5)"));
		WebElement element6_partialLinkText = driver.findElement(By.partialLinkText("Find my locator (6)"));
		WebElement element7_cssSelector = driver.findElement(By.cssSelector("input[myname='selenium']"));
		//WebElement element8_xpathClass = driver.findElement(By.xpath("//button[@class='btn btn-2']"));
		WebElement element8_xpathClass = driver.findElement(By.xpath("//*[@id='contact_info_left']/button"));

		System.out.println(element1_ID.getText());
		System.out.println(element2_name.getText());
		System.out.println(element3_name.getText());
		System.out.println(element4_classNname.getText());
		System.out.println(element5_linkText.getText());
		System.out.println(element6_partialLinkText.getText());
		System.out.println(element7_cssSelector.getAttribute("value"));
		System.out.println(element8_xpathClass.getText());
	}

	@AfterClass
	public void CloseSession()
	{
		driver.quit();
	}
}