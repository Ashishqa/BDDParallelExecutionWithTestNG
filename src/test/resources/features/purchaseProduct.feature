@Regression
Feature: Purchase product
  I want to purchase product

@Regression
  Scenario: Purchase product successful
    Given I want to land on Login screen
    And I can see page title "Swag Labs"
    When I enter my login credential and click on login button
      | UserName      | Password     |
      | standard_user | secret_sauce |
    Then I should navigate to Home screen and can see header title "PRODUCTS"
    And I can see all the product list with Name
    And I can see all the product with Description
    And I can see all the product with Price
    And I can see all the product with "ADD TO CART" button
    When I add 1 item in Add to Cart button
    Then I should navigate to Proceed to Checkout screen and can see header title "CHECKOUT: YOUR INFORMATION"
    When I enter my shipping details and click on continue button
      | FirstName | LastName  | ZipCode |
      | Ashish    | Kshatriya |  382418 |
    Then I should navigate to Proceed to Checkout Over View screen and can see header title "CHECKOUT: OVERVIEW"
    And I can see only one products in the list
    And I can see description of the product
    And I can see tax applied on the product
    And I can see total proce of the product
    When I click on finish button
    Then I should navigate to Checkout complete screen and can see header title "CHECKOUT: COMPLETE!"
    And I can see "THANK YOU FOR YOUR ORDER" message on screen
    When I click on logout
    Then I should navigate on Login screen again
