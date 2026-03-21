package testngannotations;

import org.testng.annotations.Test;

public class DependsOnMethodsTest {

	@Test
	public void login() {
		System.out.println("Logged in");
		
		//this is failed..your dashboard test will be skipped
	}
	
	@Test(dependsOnMethods="login")
	public void dashboard() {
		System.out.println("I am dependant on login test");	
	}
	
}
