package uk.farnell.com.stepdefs;

import io.cucumber.java.Before;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.farnell.com.helpers.WebDriverFactory;

public class Hook {

    private static final Logger log = LoggerFactory.getLogger(Hook.class);

    private static WebDriver driver;
    private static boolean initialise = false;

    public static void initialiseWebDriver() {
        if ((driver == null)) {
            driver = WebDriverFactory.createWebDriver();
        }
    }

    public static void closeDriver() {
        log.info("Test execution finished");
        try {
            if (!(driver == null)) {
                driver.quit();
            }
        } catch (NoSuchSessionException e) {
            log.info("Selenium session is no longer active");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void beforeAll() {
        if (!initialise) {
            initialiseWebDriver();
            log.info("Test execution started");
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                log.info("Test execution finished");
                closeDriver();
            }));
            initialise = true;

        }
    }

}
