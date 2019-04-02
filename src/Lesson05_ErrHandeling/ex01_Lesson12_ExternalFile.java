package Lesson05_ErrHandeling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//Imports for External File
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ex01_Lesson12_ExternalFile 
{
	WebDriver driver;

	@BeforeClass
	public void BeforeSession() throws ParserConfigurationException, SAXException, IOException //recognize [getData("chromePath")]
	{
		System.setProperty("webdriver.chrome.driver", getData("chromePath"));
		driver = new ChromeDriver();
		driver.get(getData("url"));
		driver.manage().window().maximize();
	}


	//Function to extract external file
	public String getData(String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File("./Configuration.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile); 
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}	  
	@Test
	public void ExternalFileEx() throws ParserConfigurationException, SAXException, IOException 
	{			
   String weight = getData("weight");
//		String Height  = driver.get(getData("Height"));
		
	}
	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
	
}
