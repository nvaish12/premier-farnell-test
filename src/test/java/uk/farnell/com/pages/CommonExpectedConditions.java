package uk.farnell.com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.farnell.com.helpers.WebDriverFactory;
import uk.farnell.com.stepdefs.Hook;

import static uk.farnell.com.helpers.WebDriverFactory.baseUrl;

public class CommonExpectedConditions {

    Hook hook;

    public CommonExpectedConditions(Hook hook) {
        this.hook = hook;
    }

    public static String getBaseUrl() {
        WebDriverFactory.loadProperties();
        return baseUrl;
    }

    public WebElement waitUntilElementIsVisble(WebElement element) {
        return new WebDriverWait(hook.getDriver(), 30)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void executeJavascript(String executeScript){
        JavascriptExecutor js = (JavascriptExecutor)hook.getDriver();
        js.executeScript(executeScript);
    }

}
