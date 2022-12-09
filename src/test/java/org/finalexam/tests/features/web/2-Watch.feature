Feature: I want to see the Watch option and validate the carousel and cards

  Scenario: Watch page

    Given I move to the watch section
    When I click on the second card in the first carousel
    Then I should be able to close the card