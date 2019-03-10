package Lesson01;
import org.testng.annotations.BeforeClass;
//without testNG template since added from New Class
import org.testng.annotations.Test;

public class Test02 
{
	@BeforeClass
	public void  beforeClass()
	{
	System.out.println("Hello Shay!");
	}
	
	@Test
		public void test1()
	{
		System.out.println("Hello World!");
	}
		@Test
		public void test2()
		{
			System.out.println("Hello ISRAEL!");
		}
		
//	@AfterClass //cleanup
	
}
