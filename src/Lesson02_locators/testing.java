package Lesson02_locators;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testing
{
	WebDriver driver;
	
	@BeforeClass
	public void start()
	{
		System.out.println("start");
	}
	
	@Test
	public void te1()
	{
		System.out.println("te1");
	}

}
