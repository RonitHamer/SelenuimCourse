package Lesson03_controller;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ex01_Lesson08_BMICalc 
{
	WebDriver driver;	
	private String weightData = "50";
	private String heightData = "150";

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://atidcollege.co.il/Xamples/bmi/");
	}

	@Test
	public void Test1_BMICalc() 
	{
		driver.findElement(By.name("weight")).sendKeys(weightData);
		driver.findElement(By.id("hight")).sendKeys(heightData);
		driver.findElement(By.xpath("//*[@id='calculate_data']")).click();
		String result = driver.findElement(By.name("bmi")).getAttribute("value");
		assertEquals(result, "22", "Test failed");
	}

	@Test
	public void Test2_buttonCalc() 
	{
		//print size & location
		int actualHeight = driver.findElement(By.xpath("//*[@id='calculate_data']")).getSize().getHeight();
		int actualWidth = driver.findElement(By.xpath("//*[@id='calculate_data']")).getSize().getWidth();
		int actualLocationX = driver.findElement(By.xpath("//*[@id='calculate_data']")).getLocation().getX();
		int actualLocationY = driver.findElement(By.xpath("//*[@id='calculate_data']")).getLocation().getY();
		System.out.println("actual Height is: " + actualHeight);
		System.out.println("actual Width is: " + actualWidth);
		System.out.println("actual LocationX is: " + actualLocationX);
		System.out.println("actual LocationY is: " + actualLocationY);	
		assertEquals(actualHeight, 35, "Height Test failed");
		assertEquals(actualWidth, 133, "Width Test failed");
		assertEquals(actualLocationX, 716, "LocationX Test failed");
		assertEquals(actualLocationY, 265, "LocationY Test failed");

		assertTrue(driver.findElement(By.xpath("//*[@id='calculate_data']")).isEnabled());
		assertTrue(driver.findElement(By.xpath("//*[@id='calculate_data']")).isDisplayed());
		assertFalse(driver.findElement(By.xpath("//*[@id='calculate_data']")).isSelected());
		assertEquals(driver.findElement(By.xpath("//*[@id='calculate_data']")).getTagName(),"input");
		assertEquals(driver.findElement(By.xpath("//*[@id='calculate_data']")).getAttribute("value"),"Calculate BMI");
		//missing fields input - check error note isn't there & test is to fail
		assertTrue(driver.findElement(By.id("new_input")).isDisplayed(),"Checking Element (new_input) is Displayed");
	}

	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}