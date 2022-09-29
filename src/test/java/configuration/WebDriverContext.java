package configuration;

import org.openqa.selenium.WebDriver;

/**
 * The Class is responsible in maintaining single instance of webdriver in any given thread.
 *
 */
public class WebDriverContext {
	
	/** The driverinstance. */
	private static InheritableThreadLocal<WebDriver> driverinstance = new InheritableThreadLocal<>();

	public static WebDriver getDriver() {
		if (driverinstance.get() == null)
			throw new IllegalStateException(
					"WebDriver has not been set, Please set WebDriver instance by WebDriverContext.setDriver...");
		else
			return driverinstance.get();
	}

	public static void setDriver(WebDriver driver) {
		driverinstance.set(driver);
	}

	public static void removeDriver() {
		driverinstance.remove();
	}
}
