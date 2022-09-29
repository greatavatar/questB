package interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import configuration.TCResult;
import interfaces.BasePage;

public class CareerPathMapPage extends BasePage {
	
	/** PageFactory example but do not use */
	/*@FindBy(name = "q")
	private WebElement searchinput;*/
	
	public static final By IMAGE_CAREER_PATH = By.xpath("//img[contains(@src,'career-path')]");

	
	public CareerPathMapPage(WebDriver driver) {
		super(driver);
	}
	

}
