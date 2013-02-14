Meta:

Narrative:
Allow user to add configurable products to cart from PDP using ajax.

Scenario: Customer can add simple configurable products from PDP.
Given I am on PDP with configurable product.
When I click Add to Cart button configurable.
Then Mini cart slides down.
Then The quantity "1" and order total "$26.50" are updated to reﬂect the addition.
Then Added ites qty "1" and price "$26.50" appears ﬁrst in the list of Mini-Cart items.
Then Added ites qty "1" and price "$26.50" appears ﬁrst in the Shopping cart.


Scenario: Customer can add configurable products from PDP.
Given I am on PDP with configurable product.
When Set multiple product conﬁgurations.
And I click Add to Cart button configurable.
Then Each conﬁguration will appear as its own line item in the mini-cart shopping cart.
And Shopping cart.
And Mini cart slides down.

Scenario: Customer can't add configurable product from PDP with quantity greater than the inventory available.
Given I am on PDP with configurable product.
When I fill quantity greater than the inventory available.
And I click Add to Cart button configurable.
Then Items don't add to cart.
And Appropriate error messaging displays to the right of the Add to Cart button.