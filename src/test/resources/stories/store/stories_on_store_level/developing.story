Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Mini cart display only the three most recently added items.
Given I am on home page with products in cart.
When I add to cart 3 different items.
Then Mini cart displays only the three most recently added items.
And The most recently added item appears first.