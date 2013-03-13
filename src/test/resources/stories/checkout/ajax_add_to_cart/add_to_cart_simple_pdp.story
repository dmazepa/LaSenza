Meta:

Narrative:
Allow user to add simple products to from PDP using ajax.

Scenario: (CH46) Customer can add products from PDP.
Given I am on PDP with simple product.
When I click Add to Cart button.
Then The qty "1" and order total "CA$26.50" are updated to reflect the addition.
Then Mini cart slides down.
Then Added items qty "1" and price "CA$26.50" appears first in the list of Mini-Cart items.

Scenario: (CH47) Customer can't add product from PDP with quantity greater than the inventory available.
Given I am on PDP with simple product.
When I fill quantity "10001" greater than the inventory available.
And I click Add to Cart button.
Then Item don't add to cart.
And Appropriate error messaging displays to the right of the Add to Cart button.