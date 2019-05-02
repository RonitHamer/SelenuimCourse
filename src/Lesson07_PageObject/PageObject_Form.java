package Lesson07_PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageObject_Form 

{
	@FindBy(how= How.XPATH, using="//*[@id=\'occupation\']")
	public WebElement  occupation;
	
	@FindBy(how= How.XPATH, using="//*[@id=\'age\']")
	public WebElement  age;
	
	@FindBy(how= How.XPATH, using="//*[@id=\"location\"]")
	public WebElement  location;

}