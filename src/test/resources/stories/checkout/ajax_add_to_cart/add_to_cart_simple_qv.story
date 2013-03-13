Meta:

Narrative:
Allow user to add simple products to cart through QV using ajax.

Scenario: (CH42) Customer can add products from QV.
Given I am on QV with simple product.
When I click Add to Cart button QV.
Then Mini cart slides down.
Then Added items appears first in the list of Mini-Cart items.
And The quantity "1" and order total "CA$26.50" are updated to reflect the addition.


Scenario: (CH43) Customer can't add product from QV with quantity greater than the inventory available.
Given I am on QV with simple product.
When I fill quantity "10000" greater than the inventory available.
And I click Add to Cart button.
Then Item don't add to cart.
And Appropriate error messaging displays to the right of the Add to Cart button.