package org.finalexam.tests.steps.mobile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.finalexam.utils.MobileBaseTest;

public class StepsMobile extends MobileBaseTest {
    @Given("I am in the home screen of the app")
    public void i_am_in_the_home_screen_of_the_app() {
        environmentSetUp();
        loadDashBoardScreen();
    }
    @When("I select the Map option")
    public void i_select_the_map_option() {
        goToMapScreenProcess();
    }
    @Then("I validate that Hotel Option is available")
    public void i_validate_that_hotel_option_is_available() {
        mapScreenValidator();
    }
    @When("I select the Menu button on the dashboard page")
    public void i_select_the_menu_button_on_the_dashboard_page() {
        goToMenuScreen();
    }
    @When("I tap on the Privacy & legal option")
    public void i_tap_on_the_privacy_legal_option() {
        goToPrivacyAndLegal();
    }
    @Then("I can see a list of options")
    public void i_can_see_a_list_of_options() {
        privacyAndLegalValidations();
    }
    @When("I select the Add Plans Button in the Dashboard Page")
    public void i_select_the_add_plans_button_in_the_dashboard_page() {
        environmentSetUp();
    }
    @Then("I Check if the Reserve Dining Option is in the list")
    public void i_check_if_the_reserve_dining_option_is_in_the_list() {
        loadDashBoardScreen();
    }
    @Then("Reserve Dining Option should be enabled")
    public void reserve_dining_option_should_be_enabled() {
        addPlansValidator();
        mobileApplicationEnd();
    }
}
