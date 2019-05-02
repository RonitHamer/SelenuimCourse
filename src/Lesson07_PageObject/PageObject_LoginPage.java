package Lesson07_PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObject_LoginPage 
{
	@FindBy(name="username2")
	public WebElement  username2;

	@FindBy(name="password2")
	public WebElement  password2;
	
	@FindBy(id="submit")
	public WebElement submit;
}