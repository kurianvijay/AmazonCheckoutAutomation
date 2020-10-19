Feature: As a user I should be able to login and select items and add them to the checkout basket

#  Background:
#
#    Given that I am on the Amazon page
#    And I click on the Sign In button
#    When I add my email
#    And I click the Continue button
#    When I enter my password
#    And I click the Sign In button

  Scenario: Validate login details and add items to checkout basket

    Given that I am on the Amazon page
    And I click on the Sign In button
    When I add my email
    And I click the Continue button
    When I enter my password
    And I click the Sign In button
    And I search for an item "Baby Proofing & Corner Cushion Protector Set"
    Then I click the search button
    And I add it into my checkout basket
    And I go to my checkout basket
    Then I should be able to see it in my checkout basket "Baby Proofing & Corner Cushion Protector Set I Baby Safety Bumpers & Edge Guard to Child Proof Furniture & Tables I Pre-Taped Corners I Bumper Safe Protector I [6.2m + 8 Corner Guards] Coffee Brown"