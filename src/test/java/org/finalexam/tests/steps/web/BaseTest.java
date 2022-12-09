package org.finalexam.tests.steps.web;

import org.finalexam.configuration.web.WebDriverManager;
import org.finalexam.pages.HomePage;
import org.finalexam.pages.Watch;
import org.finalexam.reporting.Reporter;
import org.finalexam.utils.data.WebData;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import static java.lang.String.format;

public class BaseTest {
    WebDriverManager driver;
    HomePage home;
    WebData webData;
    Watch watch;

    public void testSetUp(){
        driver = new WebDriverManager(webData.getBrowser());
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", webData.getUrl()));
        driver.getDriver().get(webData.getUrl());
        driver.getDriver().manage().window().maximize();
        home = new HomePage(driver.getDriver());
    }

    public void teardown(){driver.getDriver().quit();}

    protected <T> void checkThat(String description, T actualValue, Matcher<? super T> expectedValue){
        Reporter.info(format("Checking that " + description.toLowerCase() + " [Expectation: %s]", expectedValue));
        try{
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError e){
            Reporter.error(format("Assertion error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }
}
