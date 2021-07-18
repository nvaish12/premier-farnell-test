package uk.farnell.com.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import uk.farnell.com.pages.MyAccountPage;

public class MyAccountPageSteps {

    private Hook hook;
    private MyAccountPage myaccountpage;

    public MyAccountPageSteps(Hook hook, MyAccountPage myaccountpage) {
        this.hook = hook;
        this.myaccountpage = myaccountpage;
    }

    @Then("user is logged in to the site")
    public void zcuserIsLoggedInToTheSite() throws InterruptedException {
        myaccountpage.userIsLoggedInToTheSite();
        Thread.sleep(30000);
    }

}
