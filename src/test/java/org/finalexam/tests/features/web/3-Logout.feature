Feature: I want to log out of the account

  Scenario: Log Out successful

    Given I am in the home page of ESPN application
    When I try to log out
    Then I should be able to logout successfully