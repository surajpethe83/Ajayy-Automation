package testngannotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("I am Beforetest annotation..I run before all <test> tags");
	}	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("I am beforeClass annotation..I run before all the first method in the class");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("I am beforeMethod annotation..I run before all @Test..");
	}
	@Test
	public void testclass1()
	{
		System.out.println("Actual test case ie @Testcase1");
	}	
	@Test
	public void testclass2()
	{
		System.out.println("Actual test case ir @Testcase2");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("I am afterMethod annotation..I run after all @Test methods..");
	}	
	@AfterClass
	public void afterClass()
	{
		System.out.println("I am afterClass annotation..I run after all the test methods in class are executed");
	}	
	@AfterTest
	public void afterTest()
	{
		System.out.println("I am afterTest annotation..I run after <Test> tag");
	}	
}

