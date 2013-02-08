Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Allow users to remove products from cart.
Given I am on home page with products in cart.
When I slide down mini cart.
And Click on link Remove Item.
And Accept confirmation.
Then Product removes from shopping cart.
And Mini cart updates and total count of products updated in header.
