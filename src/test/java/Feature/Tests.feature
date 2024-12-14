Feature: Testing account

  #The are
 Scenario Outline:
  Scenario Outline: Failing scenario
    Given User is on login screen
    When  User enter Email "<Email>"
    And User enter Password "<Password>"
    And User click on login button
    Then User is logged in successfully
    And User go to computers menu and select desktops
    And User choose build your own cheap computer
    And User add to cart
    And User accept Ts & Cs then checkout
    And User complete billing and shipping details
    And User complete the payment
    And user confirm order
    Then User capture order number

    Examples:
      | Email                         | Password    |
      | mamoholanemogotlane@gmail.com | Password123 |



