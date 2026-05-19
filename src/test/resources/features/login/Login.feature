Feature: Customer Login in Advantage Online Shopping

  Scenario: Failed login due to incorrect credentials
    Given that the customer navigates to the login page
    When he enters invalid login credentials
    Then he should see an error message indicating invalid username or password