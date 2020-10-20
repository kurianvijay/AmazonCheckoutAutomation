#Feature: As a user I should be able to add/update/delete items in my basket before checkout
#
#  Background:
#    Given I am on the logged in on an amazon account
#
#    Scenario: Validate add items to basket
#
#      When I search for the product <searchterm>>
#      And I choose a product "Yonex badminton shoes"
#      And I select a size "11"
#      And I click add to basket button
#      Then I should see the item in the basket

#  To be used when a scenario has multiple sets of data
#  Scenario Outline: