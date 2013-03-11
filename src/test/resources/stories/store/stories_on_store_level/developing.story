Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Allow users use their coupon codes.
Given I am on checkout page as User.
When I Enter a valid coupon code.
And Click the Apply Coupon button.
Then The coupon discount appears as a new line in the order summary and the grand total is updated.
And Message appears AutoTestCoupon (12345) has been applied to your order.
