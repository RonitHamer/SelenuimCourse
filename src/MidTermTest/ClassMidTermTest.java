package MidTermTest;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.openqa.selenium.support.ui.Select;

public class ClassMidTermTest 
{
	WebDriver driver;
	public String firstName = "Ronit";
	public String LastName = "Hamermesh";

	@BeforeTest
	public void StartSession()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://atidcollege.co.il/Xamples/pizza/");
	}

	@Test
	public void PizzaOrder() 
	{
		String initialAmount = driver.findElement(By.xpath("//*[@id=\'field_5_2\']/div/span")).getText();			  
		assertEquals(initialAmount,"$7.50");

		////enter First & Last names
		driver.findElement(By.id("input_5_22_3")).sendKeys(firstName);
		driver.findElement(By.id("input_5_22_6")).sendKeys(LastName);

		////Selection of delivery & verification amount updated to $10.50
		Select deliverySelection = new Select(driver.findElement(By.id("input_5_21")));
		deliverySelection.selectByIndex(1);
		assertEquals(driver.findElement(By.xpath("//*[@id=\'field_5_2\']/div/span")).getText(),"$10.50");

		////getting coupon Number 
		WebElement iFrameCoupon = driver.findElement(By.xpath("//*[@id=\'field_5_19\']/iframe"));
		driver.switchTo().frame(iFrameCoupon);
		String couponNumber = driver.findElement(By.xpath("//*[@id=\'coupon_Number\']")).getText();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\'input_5_20\']")).sendKeys(couponNumber);
		//placing coupon Number in comment section
		driver.findElement(By.id("gform_submit_button_5")).click();

		//verify pop up data & close it
		Alert orderSum = driver.switchTo().alert(); 
		String orderSumText = orderSum.getText();
		//System.out.println("order Sum Text contains" + orderSumText);
		
		String alertSumText =firstName+" "+LastName+" "+couponNumber;
		//System.out.println("alert Sum Text is " + alertSumText);
		
		orderSumText.equals(alertSumText);
		orderSum.accept();
	}

	@AfterTest
	public void EndSession()
	{
		driver.quit();
	}
}