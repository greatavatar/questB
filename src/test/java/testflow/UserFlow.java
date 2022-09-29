package testflow;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import interfaces.PageinstancesFactory;
import interfaces.BasePage;
import interfaces.HomePage;
import interfaces.LoginPage;


public class UserFlow extends BasePage {

	/** The driver. */
	protected WebDriver driver;


	/**
	 * Instantiates a new base page.
	 *
	 * @param driver the driver
	 */
	public UserFlow(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void Login_An_Account_To_Quest(String pEmail, String pPassword) {

		LoginPage LoginPage = PageinstancesFactory.getInstance(LoginPage.class);
		LoginPage.OpenQuestApplication();
		LoginPage.ClickLoginButton();
		LoginPage.InputUserNameTextBox(pEmail);
		LoginPage.ClickUserNameNextButton();
		LoginPage.InputPasswordTextBox(pPassword);
		LoginPage.ClickPasswordNextButton();
		LoginPage.sleepInSeconds(15);
	}
	
	
	public void Go_To_Profile_Page() {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickIconProfile();

	}
	
	public void Go_To_Available_Quest_Page() {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickLinkAvailableMenu();
	}
	
	public void Go_To_Active_Quest_Page() {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickLinkActiveMenu();
	}
	
	public void Go_To_Career_Path_Map_Page() {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickLinkCareerPathMenu();
	}
	
	public void Go_To_FAQs_Page() {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickLinkFAQMenu();
	}
	
	public void Select_Career_Quest_List_Tab() {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickQuestTab("career");

	}
	
	public void Select_Party_Quest_List_Tab() {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickQuestTab("party");

	}
	
	public void Select_Growth_Quest_List_Tab() {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickQuestTab("growth");

	}
	
	public void Select_Engage_Quest_List_Tab() {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickQuestTab("engage");

	}
	
	public void Select_Solo_Quest_List_Tab() {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickQuestTab("solo");

	}
	
	
	
	
}
