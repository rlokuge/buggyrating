/**
* Test Listener class which extends the JUnit TestWatcher
*
* @author  Rumesh Lokuge
* @version 1.0
* @since   2021-06-20
*/

package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.ClassRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class JUnitTestListener extends TestWatcher {
	@ClassRule
    private WebDriver driver;
    private final Logger logger = (Logger) LogManager.getLogger(JUnitTestListener.class); 
    private String destinaleFolder = "target/screenshot/";
       
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        takeScreenShot(description);
        logger.error("Test is Failded " + description.getMethodName());
    }

    @Override
    protected void succeeded(Description description) {
    	takeScreenShot(description);
        logger.info("Test is sucessceded " + description.getMethodName());
    }

    @Override
    public void finished(Description description) {
        logger.info("Test session is completed " + description.getMethodName());
        driver.quit();
    }

    private void takeScreenShot(Description description) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(destinaleFolder + description.getMethodName() + ".png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}