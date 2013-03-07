Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Allow users to edit products in cart.
Given I am on home page with products in cart.
When I slide down mini cart.
And Click on link Edit Item.
Then I redirects to appropriate PDP and Add to Cart button has been replaced with an Update Cart button.
And I can edit item.