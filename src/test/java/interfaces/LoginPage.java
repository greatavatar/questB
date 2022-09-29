package interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import interfaces.BasePage;

public class LoginPage extends BasePage {
	
	/** PageFactory example but do not use */
	/*@FindBy(name = "q")
	private WebElement searchinput;*/
	
	public static final By BUTTON_LOGIN = By.xpath("//button/span[contains(text(),'Log in')]");
	public static final By TEXTBOX_USERNAME_GMAIL = By.xpath("//input[@type='email']");
	public static final By TEXTBOX_PASSWORD_GMAIL = By.xpath("//input[@type='password']");
	public static final By BUTTON_USERNAME_NEXT = By.xpath("//div[@id='identifierNext']");	
	public static final By BUTTON_PASSWORD_NEXT = By.xpath("//div[@id='passwordNext']");	

	/**
	 * Instantiates a new google page.
	 *
	 * @param driver the driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickLoginButton(){
		waitToElementVisible(LoginPage.BUTTON_LOGIN);
	    clickToElement(LoginPage.BUTTON_LOGIN);
	}
	
	public void ClickUserNameNextButton(){
        waitToElementVisible(LoginPage.BUTTON_USERNAME_NEXT);
        clickToElement(LoginPage.BUTTON_USERNAME_NEXT);
	}
	
	public void ClickPasswordNextButton(){
        waitToElementVisible(LoginPage.BUTTON_PASSWORD_NEXT);
        clickToElement(LoginPage.BUTTON_PASSWORD_NEXT);
	}
	
	public void InputUserNameTextBox(String pText){
        waitToElementVisible(LoginPage.TEXTBOX_USERNAME_GMAIL);
        sendKeyToElement(LoginPage.TEXTBOX_USERNAME_GMAIL,pText);
	}
	
	public void InputPasswordTextBox(String pText){
        waitToElementVisible(LoginPage.TEXTBOX_PASSWORD_GMAIL);
        sendKeyToElement(LoginPage.TEXTBOX_PASSWORD_GMAIL,pText);
	}
	
	//-------------VERSION B2------NHIN LEN TREN THOI----------------
	public HomePage LoginB2(String pEmail,String pPassword){
		HomePage HomePage = PageinstancesFactory.getInstance(HomePage.class);	
		this.ClickLoginButton();
		this.InputUserNameTextBox(pEmail);
		this.ClickUserNameNextButton();
		this.InputPasswordTextBox(pPassword);
		this.ClickPasswordNextButton();
        return HomePage;
	}
	



}
