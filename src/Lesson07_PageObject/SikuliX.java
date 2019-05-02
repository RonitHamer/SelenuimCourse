package Lesson07_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SikuliX 
{
	WebDriver driver;
	Screen screen;

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://atidcollege.co.il/Xamples/webdriveradvance.html");	
		Screen screen = new Screen(); 
	}

	@Test
	public void f() 
	{
		screen.click("c:\\gg");
	}
}
