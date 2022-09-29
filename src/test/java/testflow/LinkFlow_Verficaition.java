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
import interfaces.CareerPathMapPage;
import interfaces.HomePage;
import interfaces.LoginPage;
import configuration.TCResult;


public class LinkFlow_Verficaition extends BasePage {

	protected WebDriver driver;

	public LinkFlow_Verficaition(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
		
	public TCResult Verify_URL_Available_Career_Tab_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Available_Party_Tab_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Available_Growth_Tab_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Available_Engage_Tab_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Available_Solo_Tab_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Active_Career_Tab_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Active_Party_Tab_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Active_Growth_Tab_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Active_Engage_Tab_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Active_Solo_Tab_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Career_Path_Map_Page(String pExpectedURL,TCResult pResult) {

		CareerPathMapPage CareerPathMapPage = PageinstancesFactory.getInstance(CareerPathMapPage.class);
		CareerPathMapPage.verifyCurrentURL(pExpectedURL, pResult);
		CareerPathMapPage.verifyElementVisible(CareerPathMapPage.IMAGE_CAREER_PATH, "Career Path Image", pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_Profile_Page(String pExpectedURL,TCResult pResult) {

		ProfilePage ProfilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		ProfilePage.verifyCurrentURL(pExpectedURL, pResult);
		ProfilePage.verifyElementVisible(ProfilePage.LABEL_USER_NAME, "User Name label", pResult);
		return pResult;	
	}
	
	public TCResult Verify_URL_FAQs_Page(String pExpectedURL,TCResult pResult) {

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		String mainWindowTab = driver.getWindowHandle();
		HomePage.switchToWindowsTitleContainAText("docs.google.com/document");
		HomePage.verifyCurrentURL(pExpectedURL, pResult);
		driver.switchTo().window(mainWindowTab);
		
		return pResult;	
	}
	
	
}
