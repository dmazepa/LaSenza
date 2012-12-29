Meta:

Narrative:
Allow user to add simple products to from PDP using ajax.

Scenario: Customer can add products from PDP.
Given I am on PDP with simple product.
When I click Add to Cart button.
Then The quantity "1" and order total "$7.00" are updated to reﬂect the addition.
And Mini cart slides down.
And Added items qty "1" and price "$7.00" appears ﬁrst in the list of Mini-Cart items.

Scenario: Customer can't add product from PDP with quantity greater than the inventory available.
Given I am on PDP with simple product.
When I fill quantity "10000" greater than the inventory available.
And I click Add to Cart button.
Then Item don't add to cart.
And Appropriate error messaging displays to the right of the Add to Cart button.