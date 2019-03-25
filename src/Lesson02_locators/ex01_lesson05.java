package Lesson02_locators;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Exercise of class #05 - Selenium WebDriver - Locators - Basic.pptx
public class ex01_lesson05
{

	WebDriver driver;

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		//driver.navigate().to("https://www.seleniumhq.org/"); //difference to .get()?
		driver.get("https://www.seleniumhq.org/");
	}
	@Test
	public void Element01_linktext() 
	{		
		//		WebElement Test = driver.findElement(By.linkText("About"));// returns webelement & not int\String\etc
		//		System.out.println("Test param's value:" + Test);
		//		driver.findElement(By.name("Rona")); //more options..
		//		driver.findElement(By.className("homepage push")); //more options..
		System.out.println("About by Link: " + driver.findElement(By.linkText("About")));
		System.out.println("About by ID: " + driver.findElement(By.id("menu_about")));
		System.out.println("About by Link: " + driver.findElement(By.partialLinkText("About")));
		System.out.println("About by Tag: " + driver.findElement(By.tagName("a")));

		List<WebElement>  AllLinks = driver.findElements(By.tagName("a"));
		System.out.println("Amount of links on page: " + AllLinks.size());//68

		List<WebElement>  AllSeleniumLinks = driver.findElements(By.partialLinkText("Selenium"));
		System.out.println("Link with Selenium: " + AllSeleniumLinks.size());
		List<WebElement>  AllseleniumLinks = driver.findElements(By.partialLinkText("selenium"));
		System.out.println("Link with selenium: " + AllseleniumLinks.size());
	}	

	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}

