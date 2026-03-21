package testngannotations;

import org.testng.annotations.Test;

public class InvocationCountTest {

	
	@Test (enabled=true, invocationCount=10)
	public void invocationCount() {
		System.out.println("I will be executed 10 times");
	}


	@Test (enabled=true, invocationCount=5)
	public void invocationCount1() {
		System.out.println("I will be executed 5 times");
	}

	@Test 
	public void invocationCount2() {
		System.out.println("I will be executed only once");
	}


}
