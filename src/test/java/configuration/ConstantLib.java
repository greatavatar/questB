package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstantLib {


	public static class Constants {
		
		/** The Constant WORKING_DIRECTORY. */
		public final static String WORKING_DIRECTORY = System.getProperty("user.dir");

		/** The Constant REPORT_DIRECTORY. */
		public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReports/AutomationResult.html";
		
		/** The Constant PROPERTY_FILE_PATH. */
		public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/test/resources/config/test.properties";

		/** The Constant PROJECT_NAME. */
		public final static String PROJECT_NAME = "Quest";

		/** The Constant EXTENT_CONFIG_PATH. */
		public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/test/resources/config/extent-config.xml";

	
		/** The Constant CHROME_DRIVER_PATH. */
		public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/chromedriver.exe";
		
		public final static String INIT_FILE_PATH = WORKING_DIRECTORY + "/src/test/resources/config/init.xml";
		
		public static int TIMEOUT = 90;
		public static String URL = "";
		public static String EMAIL_DOMAIN ="";
		public static String ENVIRONMENT = "";
		public static String HEADLESS_MODE = "no";

		public static String EMAIL = "xxx.email";
	
		public static WebDriverWait WEBDRIVERWAIT;
		public static String ORIGINAL_WINDOWN = "";
			
		public static String SSHHost = "";
		public static String SSHUser = "";
		public static String SSHPort = "";
		
		public static String DataBaseDriverName = "";
		public static String DataBase2Url = "";
		public static String DatabaseUsr = "";
		public static String DatabasePwd = "";
		
		public static String ESIp = "";
		public static String ESPort = "";
		public static String ESProtocal = "";
	}
	
	public static class Users{
		
		//----------INIT ACCOUNT FOR TESTCASES-------------------
		
		public final static String Account01 = "nfq.quest.01@nfq.asia";
		public final static String Password01 = "Wa8dTbSVoC0cyPT15bpe";
		public final static String Account02= "nfq.quest.02@nfq.asia";
		public final static String Password02 = "tgclAn5Ck4BqcdgVbnYr";
		
	}
	
	
	public class TestGroup {
		public static final String Initialization = "Initialization";

		public class AppFunction {
			public static final String Account = "Account";
			public static final String Message = "Message";
		}

		public class Priority {
			public static final String Critical = "Critical";
			public static final String High = "High";
			public static final String Medium = "Medium";
			public static final String Low = "Low";
		}

		public class Owner {
			public static final String GiangNguyen = "Giang Nguyen";
		}

		public class TestSuite {
			public static final String SmokeTest = "Smoke Test";
			public static final String Regression = "Regression";
			public static final String Test = "Test";
		}
		
		public class RemoteInformation {
			//Information for connecting BROWSERSTACK
			public static final String USERNAME = "";
			public static final String AUTOMATE_KEY = "";
			public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		}	
		
		public class RemoteSourceInformation {
			//Information for connecting SOURCELAB
			
			public static final String USERNAME = "";
			public static final String ACCESS_KEY = "";
			public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		}	
		
	}
}
