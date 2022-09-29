package interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import interfaces.BasePage;

/**
 * The Class represents GooglePage.
 *
 * @author Bharathish
 */
public class GooglePage extends BasePage {
	
	/** PageFactory example but do not use */
	/*@FindBy(name = "q")
	private WebElement searchinput;*/
	

	public static final By SEARCH_BUTTON = By.xpath("//input[@name='q']");

	/**
	 * Instantiates a new google page.
	 *
	 * @param driver the driver
	 */
	public GooglePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Searches the given text.
	 *
	 * @param key the key
	 */
	public void searchText(String key) {
		
		sendKeyToElement(SEARCH_BUTTON, key);
		
	}

}
