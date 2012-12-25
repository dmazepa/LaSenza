Meta:

Narrative:
Allow user to add simple products to from PDP using ajax.

Scenario: Customer can add products from PDP.
Given I am on PDP with simple product.
When I click Add to Cart button.
Then Added items appears ﬁrst in the list of Mini-Cart items.
And The quantity and order total are updated to reﬂect the addition.
And Mini cart slides down.

Scenario: Customer can't add product from PDP with quantity greater than the inventory available.
Given I am on PDP with simple product.
When I fill quantity greater than the inventory available.
And I click Add to Cart button.
Then Item don't add to cart.
And Appropriate error messaging displays to the right of the Add to Cart button.