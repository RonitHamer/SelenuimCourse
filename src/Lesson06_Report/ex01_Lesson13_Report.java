package Lesson06_Report;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ex01_Lesson13_Report 
{
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver.manage().window().maximize();
		driver = new ChromeDriver();
		extent = new ExtentReports("C:\\Automation\\libs\\extentreports-java-2.41.2");		
		driver.navigate().to("http://atidcollege.co.il/Xamples/bmi/");
	}

	@Test
	public void Test1_BMICalc() 
	{
//		try
//		{
//			driver.findElement(By.name("weight")).sendKeys("50");
//			driver.findElement(By.id("hight")).sendKeys("150");
//			driver.findElement(By.xpath("//*[@id='calculate_data']")).click();
//			String result = driver.findElement(By.name("bmi")).getAttribute("value");
//			assertEquals(result, "22", "Test failed");
//		}

		try
		{
			test = extent.startTest("BMI Calc", "BMI Calc test");
			driver.findElement(By.name("weight")).sendKeys("50");
			
			driver.findElement(By.id("123")).click();
			test.log(LogStatus.PASS, "Element Clicked Successfully");
			driver.findElement(By.id("456")).sendKeys("AAA");
			test.log(LogStatus.PASS, "Element Updated Successfully");
		}


		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "test failed, see details: " + e + test.addScreenCapture("C:/Automation/Images/temp.png"));
			fail(" test failed, see details: " + e);

		}
	}

	//	//new extend actions
	//	  //try catch with general 
	//	  test.log(LogStatus.FAIL,);
	//	  fail("");

	@AfterMethod
	public void afterMethod() 
	{
		extent.endTest(test); //close after all ended& not in the test
	}

	@AfterClass
	public void closeSession()
	{
		extent.flush(); //export reports data to file
		extent.close(); //close report
		driver.quit();
	}
}