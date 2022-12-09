package org.finalexam.tests.steps.web;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.core.Is.is;

public class StepsWeb extends BaseTest {
    @Given("I am in the home page of ESPN application")
    public void i_am_in_the_home_page_of_espn_application() {
        testSetUp();
    }
    @When("I try to sign up")
    public void i_try_to_sign_up() {
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

    }
    @Then("I should have entered my session")
    public void i_should_have_entered_my_session() {
        // Write code here that turns the phrase above into concrete actions

    }
    @After()
    public void quitBrowser() {
        teardown();
    }
}
