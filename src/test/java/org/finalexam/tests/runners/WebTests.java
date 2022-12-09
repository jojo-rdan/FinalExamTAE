package org.finalexam.tests.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/java/org/finalexam/tests/features/web/1-Singup.feature",
                "src/test/java/org/finalexam/tests/features/web/2-Watch.feature",
                "src/test/java/org/finalexam/tests/features/web/3-Logout.feature"},
        glue = {"org.finalexam.tests.steps.web"}
)

public class WebTests extends AbstractTestNGCucumberTests {

}
