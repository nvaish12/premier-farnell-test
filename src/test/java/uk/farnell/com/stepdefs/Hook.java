package uk.farnell.com.stepdefs;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.farnell.com.helpers.ScreenshotUtil;
import uk.farnell.com.helpers.WebDriverFactory;

public class Hook {

    private static final Logger log = LoggerFactory.getLogger(Hook.class);

    public static WebDriver driver;
    private static boolean initialise = false;
    ScreenshotUtil screenshotutil = new ScreenshotUtil(this);

    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void beforeAll() {
        if (!initialise) {
            log.info("Test execution started");
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    log.info("Test execution finished");
                    closeDriver();
                }
            });
            initialise = true;
        }
    }

    @AfterStep
    public void afterStep() {
        screenshotutil.takeScreenshot();
    }

    public static void intialiseWebDriver() {
        if((driver == null)) {
            driver = WebDriverFactory.createWebDriver();
        }
    }

    public static void closeDriver() {
        log.info("Test execution finished");
        try {
            if(!(driver == null)) {
                driver.quit();
            }
        } catch (NoSuchSessionException e) {
            log.info("Selenium session is no longer active");
        }
    }
}
