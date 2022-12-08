package org.finalexam.tests.runners;



import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
        features = "src/test/java/org.finalexam/tests/features/web.feature",
        glue = {"steps.web.StepsWeb"}
)

public class WebTests {
}
