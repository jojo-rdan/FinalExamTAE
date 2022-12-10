package org.finalexam.tests.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/java/org/finalexam/tests/features/web/Singup.feature",
        glue = {"org.finalexam.tests.steps.web"}
)

public class WebTests extends AbstractTestNGCucumberTests {

}
