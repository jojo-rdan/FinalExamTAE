package org.finalexam.tests.runners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/org/finalexam/tests/features/web/Login.feature",
        glue = {"StepsWeb"}
)

public class WebTests extends AbstractTestNGCucumberTests {
}
