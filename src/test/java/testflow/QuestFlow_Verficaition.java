package testflow;

import java.time.Duration;

import org.openqa.selenium.By;
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


public class QuestFlow_Verficaition extends BasePage {

	protected WebDriver driver;

	public QuestFlow_Verficaition(WebDriver driver) {
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
	
	public TCResult Verify_Quest_Is_In_Progress(String pQuestName, TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		By by = By.xpath("//div[text()='"+ pQuestName +"']//ancestor::div[@class='flex-grow min-w-0'][1]/preceding-sibling::div/*[//*[local-name() = 'svg']]/*[not(@fill='white')][1]");
		HomePage.verifyElementVisible(by, "In Progress symbol", pResult);
		return pResult;
	}

	public TCResult Verify_Quest_Is_Waiting_For_Approval(String pQuestName, TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		By by = By.xpath("//div[text()='"+ pQuestName +"']//ancestor::div[@class='flex-grow min-w-0'][1]/preceding-sibling::div/*[//*[local-name() = 'svg']]/*[@fill='white'][1]");
		HomePage.verifyElementVisible(by, "Waiting For Approval symbol", pResult);
		return pResult;
	}
	
	public TCResult Verify_A_Quest_Is_Exist(String pQuestName, TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		By by = By.xpath("//div[text()='"+ pQuestName +"']//ancestor::div[@class='flex-grow min-w-0'][1]/preceding-sibling::div/*[//*[local-name() = 'svg']]/*[@fill='white'][1]");
		HomePage.verifyElementVisible(by, "Quest: " + pQuestName, pResult);
		return pResult;
	}
	
	public TCResult Verify_A_Quest_Is_Not_Exist(String pQuestName, TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		By by = By.xpath("//div[text()='"+ pQuestName +"']//ancestor::div[@class='flex-grow min-w-0'][1]/preceding-sibling::div/*[//*[local-name() = 'svg']]/*[@fill='white'][1]");
		HomePage.verifyElementInvisible(by, "Quest: " + pQuestName, pResult);
		return pResult;
	}
	
	
	
}
