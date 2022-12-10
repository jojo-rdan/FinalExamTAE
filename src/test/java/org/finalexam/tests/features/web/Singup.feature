Feature: Sign Up Functionality

    In order to do processes in ESPN
    As a new user
    I want to sign up successfully

  Scenario: Sign up successfully

    Given I am in the home page of ESPN application
    When I sign up
    Then I should have entered my session
    When I move to the watch section
    And I click on the second card in the first carousel
    Then I should be able to close the card
    When I try to log out
    Then I should be able to logout successfully