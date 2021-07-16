package uk.farnell.com.stepdefs;

import io.cucumber.java.en.Given;
import uk.farnell.com.pages.RegistrationPage;

public class RegistrationSteps {

    private Hook hook;
    private RegistrationPage registrationPage;

    public RegistrationSteps(Hook hook, RegistrationPage hpage) {
        this.hook = hook;
        this.registrationPage = hpage;
    }

    @Given("^user is on the premier farnell site registration page$")
    public void user_is_on_the_premier_farnell_site_registration_page() throws InterruptedException{
        registrationPage.goToUrl();
        registrationPage.navigateToRegistrationPage();
    }

}
