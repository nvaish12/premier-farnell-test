package uk.farnell.com.pages;

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
        this.hook=hook;
        this.utils=utils;
        PageFactory.initElements(hook.getDriver(), this);
    }

    @FindBy(css = "#guestPar > a.regLink.omTagEvt")
    private WebElement registrationLink;

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElement cookies;

    public void goToUrl() {
        hook.getDriver().get(utils.getBaseUrl());
    }

    public void navigateToRegistrationPage() throws InterruptedException {
        Thread.sleep(5000);
        utils.waitUntilElementIsVisble(cookies).click();
        Thread.sleep(5000);
        utils.waitUntilElementIsVisble(registrationLink).click();
        Thread.sleep(5000);
        if (hook.getDriver().getPageSource().contains("Access Denied")) {
            hook.getDriver().navigate().to("https://uk.farnell.com/webapp/wcs/stores/servlet/UserRegistrationForm?myAcctMain=&new=Y&catalogId=15001&storeId=10151&langId=44");
        }

        Thread.sleep(5000);
    }

}
