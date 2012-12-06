Meta:

Narrative:
Main order in which mini cart displays.

Scenario: Mini cart displays for five seconds before sliding up unless the user's cursor is focused on it.
Given I am on home page with products in cart.
When I slide down mini cart.
Then Mini cart displays for five seconds before sliding up.

Scenario: Mini cart display only the three most recently added items.
Given I am on home page with products in cart.
When I add to cart 3 different items.
Then Mini cart displays only the three most recently added items.
And The most recently added item appears first.