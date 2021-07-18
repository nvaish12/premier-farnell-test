package uk.farnell.com.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import uk.farnell.com.pages.RegistrationPage;

public class RegistrationSteps {

    private final RegistrationPage registrationPage;

    public RegistrationSteps(Hook hook, RegistrationPage hpage) {
        this.registrationPage = hpage;
    }

    @Given("^user is on the premier farnell site registration page$")
    public void navigateToRegistrationPage() {
        registrationPage.goToUrl();
        registrationPage.navigateToRegistrationPage();
    }

    @When("user has entered and submitted registration details with remember me check box turned {string}")
    public void userHasEnteredAndSubmittedRegistrationDetailsWithRememberMeCheckBoxTurned(String rememberMe) {
        registrationPage.enterRegistrationDetails(rememberMe);

    }
}
