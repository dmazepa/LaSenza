Meta:

Narrative:
Allow user to add configurable products to cart from PDP using ajax.

Scenario: (CH48) Customer can add configurable products from PDP.
Given I am on PDP with configurable product.
When Set multiple product.
And I click Add to Cart button configurable.
Then Mini cart slides down.
Then Each item will appear as its own line item in the mini-cart and shopping cart.

Scenario: (CH50) Customer can add simple configurable products from PDP.
Given I am on PDP with configurable product.
When I click Add to Cart button configurable.
Then Mini cart slides down.
Then The quantity "1" and order total "CA$26.50" are updated to reflect the addition.
Then Added items qty "1" and price "CA$26.50" appears first in the list of Mini-Cart items.
Then Added items qty "1" and price "CA$26.50" appears first in the Shopping cart.

Scenario: (CH49) Customer can't add configurable product from PDP with quantity greater than the inventory available.
Given I am on PDP with configurable product.
When I fill quantity "10000" greater than the inventory available.
And I click Add to Cart button configurable.
Then Item do not add to cart configurable.
And Appropriate error messaging displays to the right of the Add to Cart button.