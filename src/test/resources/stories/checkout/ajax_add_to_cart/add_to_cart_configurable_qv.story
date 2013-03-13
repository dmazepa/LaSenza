Meta:

Narrative:
Allow user to add configurable products to cart through QV using ajax.

Scenario: (CH44) Customer can add configurable products from QV.
Given I am on QV with configurable product as User.
When Set multiple product configurations QV.
And I click Add to Cart button QV configurable.
Then Mini cart slides down.
Then Each configuration will appear as its own line item in the mini-cart and shopping cart from QV.

Scenario: (CH45) Customer can't add configurable product from QV with quantity greater than the inventory available.
Given I am on QV with configurable product as User.
When I fill quantity "10000" greater than the inventory available.
And I click Add to Cart button QV configurable.
Then Item don't add to cart configurable QV.
And Appropriate error messaging displays to the right of the Add to Cart button.