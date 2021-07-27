package uk.farnell.com.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import uk.farnell.com.pages.RegistrationPage;

import java.util.List;
import java.util.Map;

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

    @When("user enters Username as {string}, password as {string}, email as {string} and full name as {string} with remember me turned {string}")
    public void registerMultipleUsers(String username, String password, String email, String userFullName, String rememberMeOption) {
        registrationPage.registerMultipleUsers(username, password, email, userFullName, rememberMeOption);
    }

    @When("user submits the following registration details")
    public void userSubmitsTheFollowingRegistrationDetails(DataTable registrationDetails) {
        List<String> data = registrationDetails.asList();
        String username = data.get(0);
        String password = data.get(1);
        String email = data.get(2);
        String fullName = data.get(3);
        String rememberMe = data.get(4);
        registrationPage.registerMultipleUsers(username, password, email, fullName, rememberMe);
    }

    @When("user submits the following multiple registration details")
    public void registrationWithMaps(DataTable dataTable) {
        List<Map<String, String>> registrationMap = dataTable.asMaps();
        for (Map<String, String> form : registrationMap) {
            String userName = form.get("UserName");
            String password = form.get("UserPassword");
            String email = form.get("UserEmail");
            String fullName = form.get("UserFullName");
            String rememberMe = form.get("UserRegistration");
            registrationPage.registerMultipleUsers(userName, password, email, fullName, rememberMe);
        }
    }
}
