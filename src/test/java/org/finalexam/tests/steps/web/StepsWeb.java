package org.finalexam.tests.steps.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.finalexam.utils.BaseTest;

public class StepsWeb extends BaseTest{
    @Given("I am in the home page of ESPN application")
    public void i_am_in_the_home_page_of_espn_application() {
        testSetUp();
    }

    @When("I sign up")
    public void i_sign_up() {
        signUp();
    }

    @Then("I should have entered my session")
    public void i_should_have_entered_my_session() {
        userEntered();
    }

    @When("I move to the watch section")
    public void i_move_to_the_watch_section() {
        watchProcess();
    }

    @When("I click on the second card in the first carousel")
    public void i_click_on_the_second_card_in_the_first_carousel() {
        watchValidations();
    }

    @Then("I should be able to close the card")
    public void i_should_be_able_to_close_the_card() {
        closeWatchCard();
    }

    @When("I try to log out")
    public void i_try_to_log_out() {
        logOutProcess();
    }

    @Then("I should be able to logout successfully")
    public void i_should_be_able_to_logout_successfully() {
        logOutValidation();
        teardown();
    }
}
