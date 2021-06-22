/**
* Parent class for all the test classes 
* Responsible of conducting common actions before and after test cases and test suites
*
* @author  Rumesh Lokuge
* @version 1.0
* @since   2021-06-20
*/

package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utilities.JUnitTestListener;
import utilities.PropertyFileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.apache.logging.log4j.core.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;

@TestInstance(Lifecycle.PER_CLASS)

public class BaseTestClass {

	private final Logger logger = (Logger) LogManager.getLogger(BaseTestClass.class);
	private WebDriver driver;
	public JUnitTestListener testListener;
	public static PropertyFileReader propertyFileReader;

	public BaseTestClass() {
		testListener = new JUnitTestListener();
		propertyFileReader = new PropertyFileReader();
	}

	@BeforeAll
	public void setupApplication() {
		logger.info("Browser session is started");
		setDriver();
		loadUrl();
		logger.info("Test execution is initiated");
	}

	@Before
	public void setUp() {
		logger.info("SetUp is initiated");
		testListener.setDriver(getDriver());
	}

	@After
	public void tearDown() {
		logger.info("TearDown is completed");
	}

	@AfterAll
	public void completeTesting() {
		logger.info("Test execution is completed");
		getDriver().quit();
		logger.info("Browser session is closed");
	}

	public void setDriver() {
		String browser = propertyFileReader.readProperty("browser");
		long implicitWait = Integer.parseInt(propertyFileReader.readProperty("implicitWaitInSeconds"));
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", propertyFileReader.readProperty("chromeDriver"));
			driver = new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", propertyFileReader.readProperty("ieDriver"));
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", propertyFileReader.readProperty("firefoxDriver"));
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", propertyFileReader.readProperty("edgeDriver"));
			driver = new FirefoxDriver();
			break;
		default:
			throw new WebDriverException();
		}
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void loadUrl() {
		URL baseUrl;
		HttpURLConnection connection = null;
		try {
			baseUrl = new URL(propertyFileReader.readProperty("url"));
			connection = (HttpURLConnection) baseUrl.openConnection();
			connection.connect();
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				logger.error("Unable to connect to the url connection");
				logger.error("Response Code " + connection.getResponseCode());
				logger.error("Response Message " + connection.getResponseMessage());
			}
			getDriver().get(propertyFileReader.readProperty("url"));
		} catch (IOException e) {
			logger.error("URL connection error");
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}