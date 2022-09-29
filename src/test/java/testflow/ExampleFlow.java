package testflow;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import interfaces.BasePage;
import interfaces.GooglePage;
import interfaces.PageinstancesFactory;

public class ExampleFlow extends BasePage {

	/** The driver. */
	protected WebDriver driver;

	public ExampleFlow(WebDriver driver) {
		super(driver);
	}
	
	public static void searchText(String key) {
		GooglePage googlePage = PageinstancesFactory.getInstance(GooglePage.class);
		googlePage.searchText("abc");
		//SEARCH_BUTTON.sendKeys(key + Keys.ENTER);
	}
	
	

}
