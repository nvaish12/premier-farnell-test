package uk.farnell.com.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.farnell.com.stepdefs.Hook;


public class RegistrationPage {

    private static final Logger log = LoggerFactory.getLogger(RegistrationPage.class);
    Hook hook;
    CommonExpectedConditions utils;

    public RegistrationPage(Hook hook, CommonExpectedConditions utils) {
        this.hook = hook;
        this.utils = utils;
        PageFactory.initElements(hook.getDriver(), this);
    }

    Faker faker = new Faker();

    @FindBy(xpath = "//*[@class='regLink omTagEvt']")
    private WebElement registrationLink;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookies;

    @FindBy(id = "logonId")
    private WebElement userName;

    @FindBy(id = "logonPassword")
    private WebElement userPassword;

    @FindBy(id = "firstName")
    private WebElement fullName;

    @FindBy(id = "email1")
    private WebElement email;

    @FindBy(id = "registerValidate")
    private WebElement registerButton;

    public void goToUrl() {
        hook.getDriver().get(utils.getBaseUrl());
    }

    public void navigateToRegistrationPage() throws InterruptedException {
        utils.waitForPageLoad();
        log.info("waiting for the cookies");
        if (cookies.isDisplayed()) {
            cookies.click();
            log.info("clicked on the cookies");
            hook.getDriver().manage().deleteAllCookies();
        }
        utils.waitUntilElementIsVisble(registrationLink).click();
        utils.waitUntilElementIsVisble(cookies).click();
    }

    public void enterRegistrationDetails(String rememberMe) {
        utils.waitForPageLoad();
        userName.sendKeys(faker.name().username());
        userPassword.sendKeys("TestPassword@1");
        fullName.sendKeys(faker.name().fullName());
        email.sendKeys(faker.internet().safeEmailAddress());
        if (rememberMe.equalsIgnoreCase("off")) {
            utils.executeJavascript("document.getElementById(\"rememberMe\").click()");

        }
        registerButton.click();

    }


}
