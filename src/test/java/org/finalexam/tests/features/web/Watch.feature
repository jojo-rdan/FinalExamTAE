Feature: I want to see the Watch option and validate the carousel and cards

  Background:
    Given I am a valid user logged into ESPN

  Scenario: Watch page

    Given I am in the home page of ESPN application
    And I move to the watch section
    When I click on the second card in the first carousel
    Then I should be able to close the card