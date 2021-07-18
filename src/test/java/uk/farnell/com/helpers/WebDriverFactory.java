package uk.farnell.com.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {

    public static WebDriver driver;
    public static Properties prop;
    public static String targetBrowser;
    public static String baseUrl;
    public static String currentDirectory;
    public static String pathOfScreenshot;
    public static FileInputStream fis;
    public static void loadProperties() {
        currentDirectory = System.getProperty("user.dir");
        prop = new Properties();
        try {
            fis = new FileInputStream(currentDirectory + "/src/test/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        baseUrl = prop.getProperty("url");
        pathOfScreenshot = prop.getProperty("screenshotsPath");
        targetBrowser = System.getProperty("browser", "chrome");
    }

    public static WebDriver createWebDriver() {
        loadProperties();
        switch (targetBrowser) {
            case "chrome":
                WebDriverManager.chromedriver().clearPreferences();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            case "firefox":
                WebDriverManager.firefoxdriver().clearPreferences();
                WebDriverManager.firefoxdriver().setup();
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "target/gecko.log");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            case "ie":
                WebDriverManager.iedriver().clearPreferences();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                return driver;
            case "edge":
                WebDriverManager.edgedriver().clearPreferences();
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                return driver;
            case "opera":
                WebDriverManager.operadriver().clearPreferences();
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                driver.manage().window().maximize();
                return driver;
            default:
                throw new RuntimeException("Unsupported Browser: " + driver);
        }
    }

}


