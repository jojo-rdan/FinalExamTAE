package org.finalexam.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.finalexam.configuration.web.WebDriverManager;
import org.finalexam.pages.HomePage;
import org.finalexam.pages.Watch;
import org.finalexam.reporting.Reporter;
import org.finalexam.utils.data.WebData;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.core.Is.is;

import static java.lang.String.format;

public class BaseTest {
    WebDriverManager driver;
    HomePage home;
    WebData webData;
    Watch watch;

    public void testSetUp(){
        webData = new WebData();
        driver = new WebDriverManager(webData.getBrowser());
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", webData.getUrl()));
        driver.getDriver().get(webData.getUrl());
        driver.getDriver().manage().window().maximize();
        home = new HomePage(driver.getDriver());
    }
    protected <T> void checkThat(String description, T actualValue, Matcher<? super T> expectedValue){
        Reporter.info(format("Checking that " + description.toLowerCase() + " [Expectation: %s]", expectedValue));
        try{
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError e){
            Reporter.error(format("Assertion error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }
    public void signUp(){
        home.mouseOverUser();
        home.clickOnLogInHomePage();
        home.goToIframe();
        checkThat("Log In modal is available", home.isLogInModalDisplayed(), is(true));
        checkThat("ESPN logo is available", home.isLogoDisplayed(), is(true));
        checkThat("Log In button is available", home.isLogInDisplayed(), is(true));
        checkThat("Sign Up button is available", home.isSignUpDisplayed(), is(true));
        home.clickOnSignUpButton();
        checkThat("Title is available", home.isSignUpTitleDisplayed(), is(true));
        checkThat("First Name is available", home.isFirstNameDisplayed(), is(true));
        checkThat("Last Name is available", home.isLastNameDisplayed(), is(true));
        checkThat("Email is available", home.isEmailDisplayed(), is(true));
        checkThat("Password is available", home.isPasswordDisplayed(), is(true));
        checkThat("Sign Up button is available", home.isSignUpButtonDisplayed(), is(true));
        checkThat("Close button is available", home.isCloseOptionDisplayed(), is(true));
        home.typeFirstName();
        home.typeLastName();
        home.typeEmail();
        home.typePassword();
        home.clickOnSignUpButtonFromModal();
        home.clickOnSignUpCloseButton();
    }
    public void userEntered(){
        home.mouseOverUser();
        checkThat("The user should have entered the session", home.isUsernameDisplayed(), is(true));
    }
    public void logIn(){
        home.mouseOverUser();
        home.clickOnLogInHomePage();
        home.goToIframe();
        home.typeEmail();
        home.typePassword();
        home.clickOnLogInButton();
        home.getOutIframe();
    }
    public void watchProcess(){
        home.goToWatchPage();
        watch = new Watch(driver.getDriver());
    }
    public void watchValidations(){
        checkThat("At least one carousel is present", watch.atLeastOneCarouselIsDisplayed(), is(true));
        watch.clickOnSecondCardFirstCarousel();
        checkThat("X button to close is present", watch.isXButtonDisplayed(), is(true));
    }
    public void closeWatchCard(){
        watch.clickOnXButton();
    }
    public void logOutProcess(){
        watch.previousPage();
        watch.mouseOverUser();
        checkThat("The element 'Nav text' has the right information previously\n" +
                "entered in the sign up modal: 'Welcome {{username}}!'", watch.isUsernameDisplayed(), is(true));
        watch.clickOnLogOutButton();
    }
    public void logOutValidation(){
        watch.mouseOverUser();
        checkThat("The user has logged out successfully i.e. Validate the element 'Nav text'\n" +
                "has text: 'Welcome!' without user name specified", watch.isUsernameNotDisplayed(), is(true));
    }
    public void teardown(){driver.getDriver().quit();}


}
