package org.finalexam.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/java/org/finalexam/tests/features/mobile/mobile.feature",
        glue = {"org.finalexam.tests.steps.mobile"}
)
public class MobileTests extends AbstractTestNGCucumberTests {
}
