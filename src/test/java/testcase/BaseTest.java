package testcase;

import java.io.File;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import configuration.ConstantLib;
import configuration.TCResult;
import configuration.WebDriverContext;
import configuration.ConstantLib.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.LogListener;
import listeners.ReportListener;
import util.LoggerUtil;
import util.MailUtil;
import util.TestProperties;

@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {

	/** The driver. */
	protected WebDriver driver;
	public TCResult Result;
	
	public WebDriver GetDriver()
	{
		return driver;
	}

	/**
	 * Global setup.
	 */
	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		try {
			File inputFile = new File(Constants.INIT_FILE_PATH);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);

			NodeList nList = doc.getElementsByTagName("Quest");
			Constants.URL = ((Element) nList.item(0)).getElementsByTagName("URL").item(0).getTextContent();
			Constants.EMAIL_DOMAIN = ((Element) nList.item(0)).getElementsByTagName("EmailDomain").item(0).getTextContent();
			Constants.ENVIRONMENT = ((Element) nList.item(0)).getElementsByTagName("RemoteEnvironment").item(0).getTextContent();
			Constants.HEADLESS_MODE = ((Element) nList.item(0)).getElementsByTagName("HeadlessMode").item(0).getTextContent();
			//--Get SSH Parameters
			Constants.SSHHost = ((Element) nList.item(0)).getElementsByTagName("SSHHost").item(0).getTextContent();
			Constants.SSHUser = ((Element) nList.item(0)).getElementsByTagName("SSHUser").item(0).getTextContent();
			Constants.SSHPort = ((Element) nList.item(0)).getElementsByTagName("SSHPort").item(0).getTextContent();
			//--Get SQL Parameters
			Constants.DataBaseDriverName = ((Element) nList.item(0)).getElementsByTagName("DataBaseDriverName").item(0).getTextContent();
			Constants.DataBase2Url = ((Element) nList.item(0)).getElementsByTagName("DataBase2Url").item(0).getTextContent();
			Constants.DatabaseUsr = ((Element) nList.item(0)).getElementsByTagName("DatabaseUsr").item(0).getTextContent();
			Constants.DatabasePwd = ((Element) nList.item(0)).getElementsByTagName("DatabasePwd").item(0).getTextContent();
			//--Get ES Parameters
			Constants.ESIp = ((Element) nList.item(0)).getElementsByTagName("ESIp").item(0).getTextContent();
			Constants.ESPort = ((Element) nList.item(0)).getElementsByTagName("ESPort").item(0).getTextContent();
			Constants.ESProtocal = ((Element) nList.item(0)).getElementsByTagName("ESProtocal").item(0).getTextContent();
			
			// Catching value of parameter running by command (JENKIN)
			if(System.getProperty("browser") != null)
			{
				Constants.ENVIRONMENT = System.getProperty("browser");
			}
			
			if(System.getProperty("headless") != null)
			{
				Constants.HEADLESS_MODE = System.getProperty("headless");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LoggerUtil.log("************************** Test Execution Started ************************************");
		TestProperties.loadAllPropertie();
	}

	/**
	 * Wrap all up.
	 *
	 * @param context the context
	 */
	@AfterSuite(alwaysRun = true)
	public void wrapAllUp(ITestContext context) {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		LoggerUtil.log("Total number of testcases : " + total);
		LoggerUtil.log("Number of testcases Passed : " + passed);
		LoggerUtil.log("Number of testcases Failed : " + failed);
		LoggerUtil.log("Number of testcases Skipped  : " + skipped);
		boolean mailSent = MailUtil.sendMail(total, passed, failed, skipped);
		LoggerUtil.log("Mail sent : " + mailSent);
		LoggerUtil.log("************************** Test Execution Finished ************************************");
	}

	/**
	 * Setup.
	 */
	@BeforeMethod
	protected void setup() {

		Result = new TCResult();
		String browserName = "chrome";
		switch (browserName) {
		/*case "firefox":
            WebDriverManager.firefoxdriver().setup();
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, WORKING_DIRECTORY + "\\FirefoxLogs.txt");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--disable-notifications");
            driver = new FirefoxDriver();
            break;
        case "firefox_headless":
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            driver = new FirefoxDriver(options);
            driver.manage().window().setSize(new Dimension(1600, 900));
            break;*/
        case "chrome":
//    		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
    		WebDriverManager.chromedriver().setup();
    		ChromeOptions ops1 = new ChromeOptions();
    		ops1.addArguments("disable-infobars");
    		driver = new ChromeDriver(ops1);
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		WebDriverContext.setDriver(driver);
            break;
        case "chrome_headless":
            WebDriverManager.chromedriver().setup();
            ChromeOptions ops2 = new ChromeOptions();
            ops2.addArguments("disable-infobars");
            ops2.setHeadless(true);
    		driver = new ChromeDriver(ops2);
            driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebDriverContext.setDriver(driver);
            break;
        default:
            System.out.println("Please input your browser name!");
            break;
		}
		
	}

	/**
	 * Wrap up.
	 */
	@AfterMethod
	public void wrapUp(ITestResult IResult) {
		System.out.println ("\r\n Testcase was run is " + IResult.getMethod().getMethodName());
		if (driver != null) {
			//driver.close();
			//driver.quit();
			closeBrowserAndDriver(driver);
		}
	}
	
	public void closeBrowserAndDriver(WebDriver driver) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            // Declare command line to execute
            String cmd = "";
            if(driver != null) {
                driver.quit();
            }

            if (driver.toString().toLowerCase().contains("chrome")) {
                if(osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            }else if (driver.toString().toLowerCase().contains("internetexplorer")) {
                if(osName.toLowerCase().contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            }else if (driver.toString().toLowerCase().contains("firefox")) {
                if(osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            }

            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
