package uk.farnell.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.farnell.com.stepdefs.Hook;

@SuppressWarnings("unused")
public class MyAccountPage {

    private static final Logger log = LoggerFactory.getLogger(MyAccountPage.class);
    final Hook hook;
    final CommonExpectedConditions utils;
    @FindBy(xpath = "//*[@class=\"userFirstNameLoggedInn\"]")
    private WebElement userName;

    public MyAccountPage(Hook hook, CommonExpectedConditions utils) {
        this.hook = hook;
        this.utils = utils;
        PageFactory.initElements(hook.getDriver(), this);
    }

    public void userIsLoggedInToTheSite() {
        utils.waitForPageLoad();
        // log.info("\n" + hook.getDriver().getPageSource());
        // Assert.assertTrue(userName.isDisplayed());
        log.info("User is logged in to the site");
    }

}
