package testflow;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import interfaces.PageinstancesFactory;
import interfaces.ProfilePage;
import interfaces.BasePage;
import interfaces.HomePage;
import interfaces.LoginPage;
import configuration.TCResult;


public class UserFlow_Verficaition extends BasePage {

	protected WebDriver driver;

	public UserFlow_Verficaition(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public TCResult Verify_User_Login_Successful(String pUserName, TCResult pResult) {

		ProfilePage ProfilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		ProfilePage.verifyElementText(ProfilePage.LABEL_USER_NAME, "User Name label", pUserName, pResult);
		ProfilePage.verifyElementVisible(ProfilePage.LABEL_QUESTS_COMPLETED_NUMBER, "Quest Complete Number label", pResult);
		ProfilePage.verifyElementVisible(ProfilePage.LABEL_QUESTS_COMPLETED_NUMBER, "Endorsement Number label", pResult);
		return pResult;
	}
	
	public TCResult Verify_JobTitle_In_Home_Page(String pCurrentJobTitle, String pNextJobTitle, TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyElementText(HomePage.LABEL_CURRENT_JOBTITLE, "Current JobTitle Label", pCurrentJobTitle, pResult);
		HomePage.verifyElementText(HomePage.LABEL_NEXT_JOBTITLE, "Next JobTitle Label", pNextJobTitle, pResult);
		HomePage.verifyElementText(HomePage.LABEL_MENU_JOBTITLE, "Menu JobTitle Label", pCurrentJobTitle, pResult);
		return pResult;
	}
	
	public TCResult Verify_JobTitle_In_Profile_Page(String pCurrentJobTitle, TCResult pResult) {

		ProfilePage ProfilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		ProfilePage.verifyElementText(ProfilePage.LABEL_JOBTITLE, "Current JobTitle Label", pCurrentJobTitle, pResult);
		return pResult;	
	}
	
	public TCResult Verify_CareerQuest_List_Exist(TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyElementVisible(HomePage.PANEL_CAREER_QUEST, "Career Quest List", pResult);
		return pResult;	
	}
	
	public TCResult Verify_CatchupQuest_List_Exist(TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyElementVisible(HomePage.PANEL_CATCHUP_QUEST, "Catchup Quest List", pResult);
		return pResult;	
	}
	
}
