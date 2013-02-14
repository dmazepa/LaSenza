Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Customer can't add configurable product from PDP with quantity greater than the inventory available.
Given I am on PDP with configurable product.
When I fill quantity greater than the inventory available.
And I click Add to Cart button configurable.
Then Items don't add to cart.
And Appropriate error messaging displays to the right of the Add to Cart button.
