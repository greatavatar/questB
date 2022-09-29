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
import interfaces.BasePage;
import interfaces.HomePage;
import interfaces.LoginPage;


public class QuestFlow extends BasePage {

	/** The driver. */
	protected WebDriver driver;

	/**
	 * Instantiates a new base page.
	 *
	 * @param driver the driver
	 */
	public QuestFlow(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void Select_A_Career_Quest(String pQuestName){

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickAQuest("career", pQuestName);
	}
	
	public void Select_A_Party_Quest(String pQuestName){

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickAQuest("party", pQuestName);
	}
	
	public void Select_A_Growth_Quest(String pQuestName){

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickAQuest("growth", pQuestName);
	}
	
	public void Select_A_Engagement_Quest(String pQuestName){

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickAQuest("engage", pQuestName);
	}
	
	public void Select_A_Solo_Quest(String pQuestName){

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickAQuest("solo", pQuestName);
	}
	
	public void Expand_Children_A_Career_Quest(String pQuestName){

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickToExpandChildrenOfAQuest("career", pQuestName);
	}
	
	public void Start_A_Quest(){

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickBeginQuestButton();
	}
	
	public void Abandon_A_Quest(){

		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);
		HomePage.ClickAbandonQuestButton();
	}
	
}
