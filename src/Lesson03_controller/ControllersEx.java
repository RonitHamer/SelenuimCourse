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

public class ControllersEx 
{
	WebDriver driver;
	private String lastName="Hamermesh";

	@BeforeClass
	public void beforeStart() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://atidcollege.co.il/Xamples/ex_controllers.html");
		driver.manage().window().maximize();
	}

	@Test 
	public void Test1_Controllers() 
	{
		///
		//driver.findElement(By.name("firstname")).clear(); - not needed if declaring on param "firstname"
		driver.findElement(By.name("firstname")).sendKeys("Ronit"); 
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		Select continentsSelection  = new Select(driver.findElement(By.id("continents")));
		continentsSelection.selectByVisibleText("Asia");
		driver.findElement(By.id("sex-0")).click(); 
		driver.findElement(By.id("exp-2")).click();

		driver.findElement(By.id("datepicker")).click();
		//		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click(); // go to next month
		WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
		List<WebElement> boxes = dateWidget.findElements(By.tagName("td"));
		for (WebElement box : boxes )
		{
			if(box.getText().equals("15"))
			{
				box.click();
				break;
			}
		}	

		driver.findElement(By.id("submit")).click();//Button of submit
		String CurrentUrl = driver.getCurrentUrl();
		if (CurrentUrl.contains(lastName) && CurrentUrl.contains("Hamermesh"))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");

		// Bonus Question - datepicker=....04%2F15%2F2019&...
		String[] arr = driver.getCurrentUrl().split("%");//04
		String day = arr[0].substring(arr[0].length() - 2);
		String mounth = arr[1].substring(arr[1].length() - 2);
		String year = arr[2].substring(2,6);
		System.out.println(year + "-" + mounth + "-" + day);
	}

	//	@Test 
	//	public void Test2_classInfo() 
	//	{
	//		driver.findElement(By.id("myButton")).click();
	//		driver.findElement(By.id("myButton")).submit();
	//	}

	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}
