Feature: As a user I should be able to login and select items and add them to the checkout basket

  Scenario: Validate login details and add an item to checkout basket

    Given that I am on the Amazon page
    When I login with my username and password
    And I search for an item
    And I add it into my checkout basket
    And I go to my checkout basket
    Then I should be able to see it in my checkout basket
    And I should be able to clear the contents of my basket
    Then I should be able to logout
