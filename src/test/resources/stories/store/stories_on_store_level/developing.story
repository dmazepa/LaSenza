Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Allow guests go to the Checkout.
Given I am on home page with products in cart.
When I slide down mini cart.
And Click on link Checkout.
Then I redirects to the first step of checkout process for guest.