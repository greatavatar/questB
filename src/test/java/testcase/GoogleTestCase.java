package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import interfaces.GooglePage;
import interfaces.HomePage;
import interfaces.LoginPage;
import interfaces.PageinstancesFactory;
import testflow.ExampleFlow;


@Test(testName = "Google search test", description = "Test description example")
public class GoogleTestCase extends BaseTest {

	/**
	 * Google search test.
	 */
	@Test
	public void googleSearchTest() {
		driver.get("https://www.google.co.in/");
		//GooglePage googlePage = PageinstancesFactory.getInstance(GooglePage.class);
		//googlePage.searchText("abc");
		//Assert.assertTrue(driver.getTitle().contains("abc"), "Title doesn't contain abc : Test Failed");
		
		ExampleFlow.searchText("abc");
		Assert.assertTrue(Result.Result, Result.Message);
		
	}
	
	@Test
	public void TC002_LoginSuccessfully1() {
		driver.get("https://app.integration.quest.nfq.asia/");
		LoginPage LoginPage = PageinstancesFactory.getInstance(LoginPage.class);
		HomePage HomePage = LoginPage.LoginB2("nfq.quest.01@nfq.asia","vxp1qmf@myp@PEZ-qkx");
		HomePage.ClickIconProfile();
		//Assert dai example thoi
		Assert.assertTrue(Result.Result, Result.Message);
		
	}
}
