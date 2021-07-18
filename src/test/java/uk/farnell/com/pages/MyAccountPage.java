package uk.farnell.com.pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.farnell.com.stepdefs.Hook;

public class MyAccountPage {

    private static final Logger log = LoggerFactory.getLogger(MyAccountPage.class);
    Hook hook;
    CommonExpectedConditions utils;

    public MyAccountPage(Hook hook, CommonExpectedConditions utils) {
        this.hook = hook;
        this.utils = utils;
        PageFactory.initElements(hook.getDriver(), this);
    }

    @FindBy(xpath ="//*[@class=\"userFirstNameLoggedInn\"]")
    private WebElement userName;

    public void userIsLoggedInToTheSite() throws InterruptedException{
        utils.waitForPageLoad();

       // log.info("\n" + hook.getDriver().getPageSource());
       // Assert.assertTrue(userName.isDisplayed());

    }

}
