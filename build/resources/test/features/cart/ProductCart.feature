Feature: Product Selection and Cart Management
  The customer wants to add products with different quantities to the cart.

  Scenario: Customer adds multiple products with different quantities to the cart
    Given that the customer is logged in
    When he selects one or more products
    And he adds each product to the cart with different quantities
    Then the cart should reflect the selected products with the correct quantities
