package uk.farnell.com.stepdefs;

import io.cucumber.java.en.Then;
import uk.farnell.com.pages.MyAccountPage;

public class MyAccountPageSteps {

    private final MyAccountPage myaccountpage;

    public MyAccountPageSteps(Hook hook, MyAccountPage myaccountpage) {
        this.myaccountpage = myaccountpage;
    }

    @Then("user is logged in to the site")
    public void userIsLoggedInToTheSite() {
        myaccountpage.userIsLoggedInToTheSite();
    }

}
