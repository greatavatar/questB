package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import configuration.ConstantLib.Constants;
import configuration.ConstantLib.Users;
import interfaces.GooglePage;
import interfaces.PageinstancesFactory;
import testflow.ExampleFlow;
import testflow.LinkFlow_Verficaition;
import testflow.QuestFlow;
import testflow.QuestFlow_Verficaition;
import testflow.UserFlow;
import testflow.UserFlow.*;
import testflow.UserFlow_Verficaition;


public class UserTestCase extends BaseTest {

	
	@Test(testName = "Verify Login Successful", description = "Check User Can Login Succes")
	public void TC001_Login_Successfully() {
		/*--------------PreCondition------------*/
		UserFlow UserFlow = new UserFlow(driver);
		UserFlow_Verficaition UserFlow_Verficaition = new UserFlow_Verficaition(driver);
		
		/*--------------Steps-------------------*/
		UserFlow.Login_An_Account_To_Quest(Users.Account01, Users.Password01);
		UserFlow.Go_To_Profile_Page();
		UserFlow_Verficaition.Verify_User_Login_Successful("Quest Player", Result);
		Assert.assertTrue(Result.Result, Result.Message);
		
	}
	
	@Test(testName = "Career Quest exist and correct Job Title", description = "Verify Career Quest List Exist And Correct JobTitle")
	public void TC002_User_Has_CareerQuest_And_Correct_Jobtitle() {
		/*--------------PreCondition------------*/
		UserFlow UserFlow = new UserFlow(driver);
		UserFlow_Verficaition UserFlow_Verficaition = new UserFlow_Verficaition(driver);
		
		/*--------------Steps-------------------*/
		UserFlow.Login_An_Account_To_Quest(Users.Account01, Users.Password01);
		UserFlow.Go_To_Available_Quest_Page();
		UserFlow_Verficaition.Verify_CatchupQuest_List_Exist(Result);
		UserFlow_Verficaition.Verify_CareerQuest_List_Exist(Result);
		UserFlow_Verficaition.Verify_JobTitle_In_Home_Page("PM", "SPM", Result);
		UserFlow.Go_To_Profile_Page();
		UserFlow_Verficaition.Verify_JobTitle_In_Profile_Page("PM", Result);
		Assert.assertTrue(Result.Result, Result.Message);
		
	}
	
	@Test(testName = "All links work", description = "Verify User can go to every available pages")
	public void TC003_All_Links_Work() {
	
		/*--------------PreCondition------------*/
		UserFlow UserFlow = new UserFlow(driver);
		LinkFlow_Verficaition LinkFlow_Verficaition = new LinkFlow_Verficaition(driver);
		
		/*--------------Steps-------------------*/
		UserFlow.Login_An_Account_To_Quest(Users.Account01, Users.Password01);
		
		UserFlow.Go_To_Available_Quest_Page();
		UserFlow.Select_Career_Quest_List_Tab();
		LinkFlow_Verficaition.Verify_URL_Available_Career_Tab_Page(Constants.URL + "/#/available/career", Result);
		UserFlow.Select_Party_Quest_List_Tab();
		LinkFlow_Verficaition.Verify_URL_Available_Career_Tab_Page(Constants.URL + "/#/available/group", Result);
		UserFlow.Select_Growth_Quest_List_Tab();
		LinkFlow_Verficaition.Verify_URL_Available_Career_Tab_Page(Constants.URL + "/#/available/growth", Result);
		UserFlow.Select_Engage_Quest_List_Tab();
		LinkFlow_Verficaition.Verify_URL_Available_Career_Tab_Page(Constants.URL + "/#/available/engagement", Result);
		UserFlow.Select_Solo_Quest_List_Tab();
		LinkFlow_Verficaition.Verify_URL_Available_Career_Tab_Page(Constants.URL + "/#/available/solo", Result);

		UserFlow.Go_To_Active_Quest_Page();
		UserFlow.Select_Career_Quest_List_Tab();
		LinkFlow_Verficaition.Verify_URL_Available_Career_Tab_Page(Constants.URL + "/#/active/career", Result);
		UserFlow.Select_Party_Quest_List_Tab();
		LinkFlow_Verficaition.Verify_URL_Available_Career_Tab_Page(Constants.URL + "/#/active/group", Result);
		UserFlow.Select_Growth_Quest_List_Tab();
		LinkFlow_Verficaition.Verify_URL_Available_Career_Tab_Page(Constants.URL + "/#/active/growth", Result);
		UserFlow.Select_Engage_Quest_List_Tab();
		LinkFlow_Verficaition.Verify_URL_Available_Career_Tab_Page(Constants.URL + "/#/active/engagement", Result);
		UserFlow.Select_Solo_Quest_List_Tab();
		LinkFlow_Verficaition.Verify_URL_Available_Career_Tab_Page(Constants.URL + "/#/active/solo", Result);

		UserFlow.Go_To_Career_Path_Map_Page();
		LinkFlow_Verficaition.Verify_URL_Career_Path_Map_Page(Constants.URL + "/#/career-path", Result);
		
		UserFlow.Go_To_FAQs_Page();
		LinkFlow_Verficaition.Verify_URL_FAQs_Page("https://docs.google.com/document/d/1N1sTpYq7cT3aeWoMVfcw9BxpefEm7DniEGzYORHyETg/edit", Result);
		
		
		Assert.assertTrue(Result.Result, Result.Message);
		
	}
	
	@Test(testName = "User can start and abadon a quest", description = "Verify Start/Abandon Quest. Verify Active tab")
	public void TC004_User_Can_Start_And_Abandon_A_Quest() {
		/*--------------PreCondition------------*/
		UserFlow UserFlow = new UserFlow(driver);
		QuestFlow QuestFlow = new QuestFlow(driver);
		QuestFlow_Verficaition QuestFlow_Verficaition = new QuestFlow_Verficaition(driver);
		String parentQuest = "Keep them still Happy - PM";
		String childQuest = "A Steady Pulse Is a Good Pulse - PM";
		//Note: Clear stage of ChildQuest, make sure it is Ready before testcase start => do in MYSQL database later
		
		/*--------------Steps-------------------*/
		UserFlow.Login_An_Account_To_Quest(Users.Account01, Users.Password01);
		
		UserFlow.Go_To_Available_Quest_Page();
		UserFlow.Select_Career_Quest_List_Tab();
		QuestFlow.Expand_Children_A_Career_Quest(parentQuest);
		QuestFlow.Select_A_Career_Quest(childQuest);
		QuestFlow.Start_A_Quest();
		QuestFlow_Verficaition.Verify_Quest_Is_In_Progress(parentQuest, Result);
		QuestFlow_Verficaition.Verify_Quest_Is_In_Progress(childQuest, Result);
		
		UserFlow.Go_To_Active_Quest_Page();
		UserFlow.Select_Career_Quest_List_Tab();
		QuestFlow_Verficaition.Verify_Quest_Is_In_Progress(parentQuest, Result);
		QuestFlow_Verficaition.Verify_Quest_Is_In_Progress(childQuest, Result);
		
		QuestFlow.Select_A_Career_Quest(childQuest);
		QuestFlow.Abandon_A_Quest();
		QuestFlow_Verficaition.Verify_A_Quest_Is_Not_Exist(parentQuest, Result);
		QuestFlow_Verficaition.Verify_A_Quest_Is_Not_Exist(childQuest, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);
		
	}
	
	@Test(testName = "User can start and abadon a quest", description = "Verify Start/Abandon Quest. Verify Active tab")
	public void test() {
		/*--------------PreCondition------------*/
		UserFlow UserFlow = new UserFlow(driver);
		QuestFlow QuestFlow = new QuestFlow(driver);
		QuestFlow_Verficaition QuestFlow_Verficaition = new QuestFlow_Verficaition(driver);
		String parentQuest = "Keep them still Happy - PM";
		String childQuest = "A Steady Pulse Is a Good Pulse - PM";
		//Note: Clear stage of ChildQuest, make sure it is Ready before testcase start => do in MYSQL database later
		
		/*--------------Steps-------------------*/
		UserFlow.Login_An_Account_To_Quest(Users.Account01, Users.Password01);
		UserFlow.sleepInSeconds(10);
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://google.com");
		UserFlow.sleepInSeconds(5);
		UserFlow.Login_An_Account_To_Quest(Users.Account01, Users.Password01);
		UserFlow.sleepInSeconds(5);
		
		
		Assert.assertTrue(Result.Result, Result.Message);
		
	}

}
