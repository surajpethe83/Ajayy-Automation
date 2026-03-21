package testngannotations;

import org.testng.annotations.Test;

public class IncludeExcludeTest {
	
	@Test (enabled=false)
	public void testclass1()
	{
		System.out.println("Actual test case ie @Testcase1");
	}	
	@Test (enabled=true)
	public void testclass2()
	{
		System.out.println("Actual test case ir @Testcase2");
	}

}
