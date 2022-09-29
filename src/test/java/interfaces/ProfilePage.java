package interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import configuration.TCResult;
import interfaces.BasePage;

public class ProfilePage extends BasePage {
	
	/** PageFactory example but do not use */
	/*@FindBy(name = "q")
	private WebElement searchinput;*/
	
	public static final By LABEL_USER_NAME = By.xpath("//div[contains(@class,'bg-card')]/h1");
	public static final By LABEL_QUESTS_COMPLETED_NUMBER = By.xpath("//div[text()='Quests Completed']/preceding-sibling::div");
	public static final By LABEL_ENDORSEMENT_NUMBER = By.xpath("//div[text()='Endorsements']/preceding-sibling::div");
	public static final By LABEL_JOBTITLE = By.xpath("//div[@class='text-gray'][1]");
	public static final By LABEL_YEAR_NUMBER = By.xpath("//div[@class='text-gray'][2]");
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public String GetNextJobTitle(){
		String currentJobtitle = getTextElement(ProfilePage.LABEL_JOBTITLE);
		return currentJobtitle;	
	}
	
	public String GetEndorsementNumber(){
		String currentJobtitle = getTextElement(ProfilePage.LABEL_ENDORSEMENT_NUMBER);
		return currentJobtitle;	
	}
	
	public String GetYearNumber(){
		String currentJobtitle = getTextElement(ProfilePage.LABEL_YEAR_NUMBER);
		return currentJobtitle;	
	}
	

}
