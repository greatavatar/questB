package interfaces;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import configuration.ConstantLib.Constants;
import configuration.TCResult;

public class BasePage {

	/** The driver. */
	protected WebDriver driver=null;

	/** The waiter. */
	protected FluentWait<WebDriver> waiter;

	/**
	 * Instantiates a new base page.
	 *
	 * @param driver the driver
	 */
	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
	}
	
    //private Actions action;
    //private JavascriptExecutor jsExecutor;
    //private WebDriverWait waitExplicit;
    //private Select select;
    //private List<WebElement> elements;
    private int shortTimeout = 3;
    private int longTimeout = 30;
    private Set<String> allWindows;

    public void clickToElement(By pBy) {
    	WebElement element = driver.findElement(pBy);
        element.click();
       
    }
    
    public void clickToElementByJS(By pBy) {
    	WebElement element = driver.findElement(pBy);
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void sendKeyToElement(By pBy, String pTextValue) {
        WebElement element = driver.findElement(pBy);
        element.clear();
        element.sendKeys(pTextValue);
    }
    
    public boolean isElementDisplayed(By pBy) {
    	WebElement element = driver.findElement(pBy);
        waitToElementVisible(pBy);
        return element.isDisplayed();
    }
        
    public void waitToElementVisible(By pBy) {
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(pBy));
    }


    public void setAttributeValue(By pBy, String pAttribute, String pValue) {
    	WebElement element = driver.findElement(pBy);
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
        jsExecutor.executeScript("arguments[0].setAttribute('" + pAttribute + "', '" + pValue + "')", element);
    }

    public String getTextElement(By pBy) {
    	WebElement element = driver.findElement(pBy);
        return element.getText();
    }

    /**
     * Override implicitWait in some case to reduce the wait time
     *
     * @param timeout: seconds to wait
     */
    public void overideGlobalTimeout(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    /**
     * Check the element is present in the DOM before the actions
     */
    public boolean isElementPresentInDOM(By pBy) {
        overideGlobalTimeout(shortTimeout);
        List<WebElement> elements = driver.findElements(pBy);
        overideGlobalTimeout(longTimeout);
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * For some elements inside the iframe, have to switch to iframe before locating the element
     *
     * @param locator: iframe xpath
     */
    public void switchToFrameOrIframe(By pBy) {
    	WebElement element = driver.findElement(pBy);
        driver.switchTo().frame(element);
    }

    /**
     * Get the attribute value of the element
     *
     * @param locator:       xpath of the element
     * @param attributeName: the attribute name
     * @return the attribute value of the element located
     */
    public String getAttributeValue(By pBy, String attributeName) {
    	WebElement element = driver.findElement(pBy);
        return element.getAttribute(attributeName);
    }

    public boolean isElementDisabled(By pBy) {
    	WebElement element = driver.findElement(pBy);
        return !element.isEnabled();
    }

    public void openNewTab(String pUrl) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
        jsExecutor.executeScript("window.open('" + pUrl + "','_blank');");
    }

    public void switchToWindowsByTitle(String pTitle) {
        allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWindow = driver.getTitle();
            if (currentWindow.equals(pTitle)) {
                break;
            }
        }
    }

    public void switchToWindowsTitleContainAText(String pText) {
        allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWindow = driver.getTitle();
            if (currentWindow.contains(pText)) {
                break;
            }
        }
    }
    
    public void switchToParentIframe() {
        driver.switchTo().parentFrame();
    }

    public int countElements(By pBy) {
        overideGlobalTimeout(shortTimeout);
        List<WebElement> elements = driver.findElements(pBy);
        overideGlobalTimeout(longTimeout);
        return elements.size();
    }

    public void selectItemInDropdown(By pBy, String valueItem) {
        Select select = new Select(driver.findElement(pBy));
        select.selectByVisibleText(valueItem);
    }

    public void selectItemInDropdown(By pByParent, By pByallItemsLocator, String pByExpectedItem)
            throws InterruptedException {
        WebElement parentDropdown = driver.findElement(pByParent);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", parentDropdown);
//        jsExecutor.executeScript("arguments[0].click();", parentDropdown);
        parentDropdown.click();
        Thread.sleep(1000);

        // wait for elements
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pByallItemsLocator));

        // Define list to store all listed items
        List<WebElement> allItems = driver.findElements(pByallItemsLocator);

        // Through each item to find the item
        // For each
        for (WebElement item : allItems) {
            if (item.getText().equals(pByExpectedItem)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
                Thread.sleep(1000);
                item.click();
                Thread.sleep(1000);
                break;
            }
        }
    }

    public void sleepInSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hoverMouseToElement(By pBy) {
        WebElement element = driver.findElement(pBy);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public WebElement getLastElement(By pBy) {
        List<WebElement> elements = driver.findElements(pBy);
        WebElement element = elements.get(elements.size() - 1);
        return element;
    }

    public String getCurrentDate(){
        LocalDate currentDateTime = LocalDate.now();
        int currentDay = currentDateTime.getDayOfMonth();
        Month currentMonth = currentDateTime.getMonth();
        int currentYear = currentDateTime.getYear();
        String currentDate = currentMonth + " " + currentDay + ", " + currentYear;
        return currentDate;
    }
    
    public void RefreshPage()
    {
    	driver.navigate().refresh();
    }
    
    public void NavigateURL(String pString)
    {
    	driver.navigate().to(pString);
    }
    
    public void OpenQuestApplication()
    {
    	NavigateURL(Constants.URL);
    }
    
    //--------------VERIFICATION METHOD----------------VERIFICATION METHOD-------------------------
    

	/**
	 * Verify that element is visible
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public TCResult verifyElementVisible(By pBy, String pElementName, TCResult pResult) {
		waitToElementVisible(pBy);
		WebElement element = driver.findElement(pBy);
		if (!element.isDisplayed()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is invisible, it has to be visible");
		};
		return pResult;
	}

	/**
	 * Verify that element is invisible
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public TCResult verifyElementInvisible(By pBy, String pElementName, TCResult pResult) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		int size = driver.findElements(pBy).size();
		if(size > 0)
		{
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is visible, it has to be invisible");
		}
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		return pResult;
	}

	/**
	 * Verify that element is selected
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public TCResult verifyElementSelected(By pBy, String pElementName, TCResult pResult) {
		waitToElementVisible(pBy);
		WebElement element = driver.findElement(pBy);
		if (!element.isSelected()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is not selected");
		}
		return pResult;
	}

	/**
	 * Verify that element is not selected
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public TCResult verifyElementNotSelected(By pBy, String pElementName, TCResult pResult) {
		waitToElementVisible(pBy);
		WebElement element = driver.findElement(pBy);
		if (element.isSelected()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is selected");
		}
		return pResult;
	}

	/**
	 * Compare text of actual and expected results
	 * 
	 * @param pFieldName
	 *            Name of the element
	 * @param pActualResult
	 *            Actual value needs to verify
	 * @param pExpectedResult
	 *            Expected value
	 * @param pResult
	 *            Result of test case
	 */
	public TCResult verifyElementText(By pBy,String pElementName, String pExpectedResult,
			TCResult pResult) {
		waitToElementVisible(pBy);
		WebElement element = driver.findElement(pBy);
		String ActualResult = element.getText();
		if (!ActualResult.equals(pExpectedResult)) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " with expected text: " + pExpectedResult + ". Current text is: " + ActualResult);
		}
		return pResult;
	}

	/**
	 * Verify element is enable
	 * 
	 * @param pElementName
	 *            Name of the element
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pResult
	 *            Result of the test case
	 */
	public TCResult verifyElementEnabled(By pBy, String pElementName, TCResult pResult) {
		waitToElementVisible(pBy);
		WebElement element = driver.findElement(pBy);
		if (!element.isEnabled()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is not enabled");
		}
		return pResult;
	}

	/**
	 * Verify element is disable
	 * 
	 * @param pElementName
	 *            Name of the element
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pResult
	 *            Result of the test case
	 */
	public TCResult verifyElementDisable(By pBy, String pElementName, TCResult pResult) {
		waitToElementVisible(pBy);
		WebElement element = driver.findElement(pBy);
		if (element.isEnabled()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is enabled");
		}
		return pResult;
	}
	
	/**
	 * Compare text of actual and expected results to verify Website Title
	 * 
	 * @param pActualResult
	 *            Actual value needs to verify
	 * @param pExpectedResult
	 *            Expected value
	 * @param pResult
	 *            Result of test case
	 */
	public TCResult verifyWebsiteTitle(String pExpectedResult,
			TCResult pResult) {
		String ActualResult = driver.getTitle();
		if (!ActualResult.equals(pExpectedResult)) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + "Expected webstitle's title is: " + pExpectedResult + ". Current title is: " + ActualResult);
		}
		return pResult;
	}

	/**
	 * Verify expected value in a specific attribute of a control
	 * 
	 * @param pBy
	 *            By of a element
	 * @param pAttribute
	 *            Attribute value needs to get
	 * @param pExpectedResult
	 *            Expected value
	 * @param pResult
	 *            Result of test case
	 */
	public TCResult verifyAttributeContainValue(By pBy, String pAttribute, String pExpectedResult, TCResult pResult) {
		waitToElementVisible(pBy);
		WebElement element = driver.findElement(pBy);
		String ActualResult = element.getAttribute(pAttribute);
		if (!ActualResult.contains(pExpectedResult)) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + "Expected Attribute is:" + pAttribute + " value is: " + pExpectedResult + ". Current value is: " + ActualResult);
		}
		return pResult;
	}
	
	/**
	 * Verify expected value NOT in a specific attribute of a control
	 * 
	 * @param pBy
	 *            By of a element
	 * @param pAttribute
	 *            Attribute value needs to get
	 * @param pExpectedResult
	 *            Expected value
	 * @param pResult
	 *            Result of test case
	 */
	public TCResult verifyAttributeNotContainValue(By pBy, String pAttribute, String pExpectedResult, TCResult pResult) {
		waitToElementVisible(pBy);
		WebElement element = driver.findElement(pBy);
		String ActualResult = element.getAttribute(pAttribute);
		if (ActualResult.contains(pExpectedResult) == true) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + "Expected Attribute:" + pAttribute + " value is: " + pExpectedResult + ". Current value is: " + ActualResult);
		}
		return pResult;
	}
	
	/**
	 * Verify expected value NOT in a specific attribute of a control
	 * 
	 * @param pBy
	 *            By of a element
	 * @param pAttribute
	 *            Attribute value needs to get
	 * @param pExpectedResult
	 *            Expected value
	 * @param pResult
	 *            Result of test case
	 */
	public TCResult verifyCurrentURL(String pExpectedURL, TCResult pResult) {
		String ActualURL = driver.getCurrentUrl();
		if (!ActualURL.equals(pExpectedURL)) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + "Expected URL value is: " + pExpectedURL + ". Current URL is: " + ActualURL);
		}
		return pResult;
	}

}
