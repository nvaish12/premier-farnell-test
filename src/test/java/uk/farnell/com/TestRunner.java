package uk.farnell.com;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static uk.farnell.com.stepdefs.Hook.closeDriver;
import static uk.farnell.com.stepdefs.Hook.initialiseWebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        glue = {"classpath:uk/farnell/com/stepdefs"},
        plugin = {"pretty", "json:target/cucumber.json"},
        strict = true
)
public class TestRunner {

    @BeforeClass
    public static void start() {
        initialiseWebDriver();
    }

    @AfterClass
    public static void finish() {
        closeDriver();
    }
}

