Feature: Checkout and Payment Processing
  The customer wants to complete a purchase using a valid payment method.

  Scenario: Customer completes a full purchase with a payment method
    Given that the customer already has products in the cart
    When he proceeds to checkout
    And he selects a valid payment method
    And he completes the payment process
    Then he should see a confirmation message indicating that the order was placed successfully
    And the payment amount should match the total of the products in the cart
