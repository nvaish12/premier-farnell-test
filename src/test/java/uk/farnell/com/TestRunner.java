package uk.farnell.com;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        glue = {"classpath:uk/farnell/com/stepdefs"},
        plugin = {"pretty", "json:target/cucumber.json"},
        strict = true
)
public class TestRunner {

}

