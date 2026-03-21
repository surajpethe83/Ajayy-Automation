package testngannotations;

import org.testng.annotations.Test;



public class groupsTest {

	@Test(groups = { "regression", "login", "usregion" })
	public void testcase1() {
		System.out.println("I am part of regression group");
	}

	@Test(groups = { "smoke" })
	public void testcase2() {
		System.out.println("I am part of smoke group");
	}

	@Test(groups = { "smoke" })
	public void testcase3() {
		System.out.println("I am part of smoke group");
	}

	@Test(groups = { "regression" })
	public void testcase4() {
		System.out.println("I am part of REGRESSION group");
	}

	@Test(groups = { "smoke", "regression", "usspecific" })
	public void testcase5() {
		System.out.println("I am part of smoke and Regression group");
	}
}
