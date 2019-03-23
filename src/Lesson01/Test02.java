package Lesson01;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
//without testNG template since added from New Class
import org.testng.annotations.Test;

public class Test02 
{
	@BeforeClass
	public void  beforeClass()
	{
		System.out.println("annotation name is:" + "@BeforeClass");
	}
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("annotation name is:" + "@BeforeMethod");
	}

	@Test (priority = 1)
	public void test1()
	{
		System.out.println("annotation name is:" + "@Test1");
	}
	
	@Test (priority = 0)
	public void test2()
	{
		System.out.println("annotation name is:" + "@Test2");
	}
	
	@Test (priority = 2, enabled=false)
	public void test4()
	{
		System.out.println("annotation name is:" + "@Test4");
	}

	@Test (dependsOnMethods = {"test2","test1"})
	public void test3()
	{
		System.out.println("dependsOnMethods of test1,test2");
	}

	@org.testng.annotations.AfterMethod
	public void AfterMethod()
	{
		System.out.println("annotation name is:" + "@AfterMethod");
	}

	@AfterClass  //used for cleanups
	public void  AfterClass()
	{
		System.out.println("annotation name is:" + "@AfterClass");
	}
}