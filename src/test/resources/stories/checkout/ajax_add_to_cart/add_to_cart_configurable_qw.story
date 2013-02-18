Meta:

Narrative:
Allow user to add configurable products to cart through QW using ajax.

Scenario: Customer can add configurable products from QW.
Given I am on QW with configurable product as User.
When Set multiple product conﬁgurations QV.
And I click Add to Cart button QV.
Then Mini cart slides down.
Then Each conﬁguration will appear as its own line item in the mini-cart and shopping cart from QV.

Scenario: Customer can't add configurable product from QW with quantity greater than the inventory available.
Given I am on QW with configurable product as User.
When I fill quantity "10000" greater than the inventory available.
And I click Add to Cart button QV.
Then Item don't add to cart.
And Appropriate error messaging displays to the right of the Add to Cart button.