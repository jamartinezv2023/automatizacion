Feature: Customer Login in Advantage Online Shopping
  The customer wants to securely access his account.

  Scenario: Successful login
    Given that the customer navigates to the login page
    When he enters valid login credentials
    Then he should be logged into his account successfully

  Scenario: Failed login due to incorrect credentials
    Given that the customer navigates to the login page
    When he enters invalid login credentials
    Then he should see an error message indicating invalid username or password
