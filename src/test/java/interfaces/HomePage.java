package interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import interfaces.BasePage;

public class HomePage extends BasePage {
	
	/** PageFactory example but do not use */
	/*@FindBy(name = "q")
	private WebElement searchinput;*/
	
	public static final By ICON_PROFILE = By.xpath("//div[contains(@class,'group relative transition')]/a[contains(@href,'profile')]");
	public static final By LINK_AVAILABLE_MENU = By.xpath("//div[contains(@class,'bg-main-header')]//a[contains(text(),'Available')]");
	public static final By LINK_ACTIVE_MENU = By.xpath("//div[contains(@class,'bg-main-header')]//a[contains(text(),'Active')]");
	public static final By LINK_CAREER_PATH_MENU = By.xpath("//div[contains(@class,'bg-main-header')]//a[contains(text(),'Career Path')]");
	public static final By LINK_FAQS_MENU = By.xpath("//div[contains(@class,'bg-main-header')]//a[contains(text(),'FAQs')]");
	
	public static final By PANEL_CAREER_QUEST = By.xpath("//span[contains(text(),'% Progress')]/ancestor::div[@class='mt-6 mb-4']/following-sibling::div[1]");
	public static final By PANEL_CATCHUP_QUEST = By.xpath("//span[text()='Catch-up Quests']/ancestor::div[@class='mt-6 mb-4']/following-sibling::div[1]");
	public static final By LABEL_CURRENT_JOBTITLE = By.xpath("//span[contains(text(),'% Progress')]/ancestor::div[@class='mt-6 mb-4']//div[@class='flex items-center leading-none']/span[1]");
	public static final By LABEL_NEXT_JOBTITLE = By.xpath("//span[contains(text(),'% Progress')]/ancestor::div[@class='mt-6 mb-4']//div[@class='flex items-center leading-none']/span[2]");
	public static final By LABEL_MENU_JOBTITLE = By.xpath("//div[contains(@class,'user-title')]");
	
	public static final By TAB_CAREER_QUEST_LIST = By.xpath("//div[contains(@class,'QuestTab')]/button[1]");
	public static final By TAB_PARTY_QUEST_LIST = By.xpath("//div[contains(@class,'QuestTab')]/button[2]");
	public static final By TAB_GROWTH_QUEST_LIST = By.xpath("//div[contains(@class,'QuestTab')]/button[3]");
	public static final By TAB_ENGAGE_QUEST_LIST = By.xpath("//div[contains(@class,'QuestTab')]/button[4]");
	public static final By TAB_SOLO_QUEST_LIST = By.xpath("//div[contains(@class,'QuestTab')]/button[5]");
	
	public static final By BUTTON_BEGIN_QUEST = By.xpath("//span[text()='Begin Quest']");
	public static final By BUTTON_ABANDON = By.xpath("//span[text()='Abandon']");
	public static final By BUTTON_REQUEST_FOR_APPROVAL = By.xpath("//span[text()='//span[text()='Done! Request for Approval']']");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickIconProfile(){
		waitToElementVisible(HomePage.ICON_PROFILE);
	    clickToElementByJS(HomePage.ICON_PROFILE);
	}
	
	public void ClickLinkAvailableMenu(){
		waitToElementVisible(HomePage.LINK_AVAILABLE_MENU);
	    clickToElement(HomePage.LINK_AVAILABLE_MENU);
	}
	
	public void ClickLinkActiveMenu(){
		waitToElementVisible(HomePage.LINK_ACTIVE_MENU);
		clickToElement(HomePage.LINK_ACTIVE_MENU);
	}
	
	public void ClickLinkCareerPathMenu(){
		waitToElementVisible(HomePage.LINK_CAREER_PATH_MENU);
		clickToElement(HomePage.LINK_CAREER_PATH_MENU);
	}
	
	public void ClickLinkFAQMenu(){
		waitToElementVisible(HomePage.LINK_FAQS_MENU);
		clickToElement(HomePage.LINK_FAQS_MENU);
	}

	public String GetCurrentJobTitle(){
		String currentJobtitle = getTextElement(HomePage.LABEL_CURRENT_JOBTITLE);
		return currentJobtitle;	
	}
	
	public String GetNextJobTitle(){
		String currentJobtitle = getTextElement(HomePage.LABEL_NEXT_JOBTITLE);
		return currentJobtitle;	
	}

	public void ClickQuestTab(String pTab){
		switch(pTab) {
		case "career":
			waitToElementVisible(HomePage.TAB_CAREER_QUEST_LIST);
		    clickToElementByJS(HomePage.TAB_CAREER_QUEST_LIST);
			break;
		case "party":
			waitToElementVisible(HomePage.TAB_PARTY_QUEST_LIST);
		    clickToElementByJS(HomePage.TAB_PARTY_QUEST_LIST);
			break;
		case "growth":
			waitToElementVisible(HomePage.TAB_GROWTH_QUEST_LIST);
		    clickToElementByJS(HomePage.TAB_GROWTH_QUEST_LIST);
			break;
		case "engage":
			waitToElementVisible(HomePage.TAB_ENGAGE_QUEST_LIST);
		    clickToElementByJS(HomePage.TAB_ENGAGE_QUEST_LIST);
			break;
		case "solo":
			waitToElementVisible(HomePage.TAB_SOLO_QUEST_LIST);
		    clickToElementByJS(HomePage.TAB_SOLO_QUEST_LIST);
			break;
		}
	}
	
	public void ClickAQuest(String pQuestType, String pQuestName)
	{
		By by;
		if(pQuestType.equals("career"))
			by = By.xpath("//span[contains(text(),'% Progress')]/ancestor::div[@class='mt-6 mb-4']/following-sibling::div[1]//div[text()='"+ pQuestName +"']");
		//else if(pQuestType.equals("catch up")) by = null;
		else 
			by = By.xpath("//div[contains(@class,'mt-6')]//div[text()='"+ pQuestName +"']");
		clickToElement(by);
	}
	
	
	public void ClickToExpandChildrenOfAQuest(String pQuestType, String pQuestName)
	{
		By by;
		if(pQuestType.equals("career"))
			by = By.xpath("//span[contains(text(),'% Progress')]/ancestor::div[@class='mt-6 mb-4']/following-sibling::div[1]//div[text()='"+pQuestName+"']/following-sibling::button");
		//else if(pQuestType.equals("catch up")) by = null;
		else 
			by = By.xpath("//div[contains(@class,'mt-6')]//div[text()='"+ pQuestName +"']/following-sibling::button");
		clickToElement(by);
	}
	
	public void ClickBeginQuestButton(){
		waitToElementVisible(HomePage.BUTTON_BEGIN_QUEST);
	    clickToElement(HomePage.BUTTON_BEGIN_QUEST);
	}

	public void ClickAbandonQuestButton(){
		waitToElementVisible(HomePage.BUTTON_ABANDON);
	    clickToElement(HomePage.BUTTON_ABANDON);
	}
	
	
}
