Meta:

Narrative:
Allow user to add configurable products to cart through QW using ajax.

Scenario: Customer can add configurable products from QW.
Given I am on QW with configurable product.
When Set multiple product conﬁgurations.
And I click Add to Cart button.
Then each conﬁguration will appear as its own line item in the mini-cart shopping cart.
And Shopping cart.
And Mini cart slides down.

Scenario: Customer can't add configurable product from QW with quantity greater than the inventory available.
Given I am on QW with configurable product.
When I fill quantity greater than the inventory available.
And I click Add to Cart button.
Then Items don't add to cart.
And Appropriate error messaging displays to the right of the Add to Cart button.