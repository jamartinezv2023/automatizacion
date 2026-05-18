Feature: User Registration in Advantage Online Shopping
  The customer wants to create an account to start shopping.

  Scenario: Successful user registration
    Given that the customer navigates to the Advantage Online Shopping homepage
    When he registers with valid personal information
    Then he should see a confirmation message indicating that the account was created successfully

  Scenario: Failed registration due to existing username
    Given that the customer navigates to the Advantage Online Shopping homepage
    When he tries to register using an already registered username
    Then he should see a message indicating that the username already exists
