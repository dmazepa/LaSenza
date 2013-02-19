Meta:

Narrative:
Allow user to add simple products to cart through QW using ajax.

Scenario: Customer can add products from QW.
Given I am on QW with simple product.
When I click Add to Cart button QV.
Then Mini cart slides down.
Then Added items appears ﬁrst in the list of Mini-Cart items.
And The quantity "1" and order total "$26.50" are updated to reﬂect the addition.


Scenario: Customer can't add product from QW with quantity greater than the inventory available.
Given I am on QW with simple product.
When I fill quantity "10000" greater than the inventory available.
And I click Add to Cart button.
Then Item don't add to cart.
And Appropriate error messaging displays to the right of the Add to Cart button.