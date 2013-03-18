Meta:

Narrative:
Allow Users use his discounts.

Scenario: (CH28) Disallow users use their invalid coupon codes.
Given I am on checkout page as User.
When I Enter a invalid coupon code.
And Click the Apply Coupon button.
Then message appears: promo code name is invalid or qualifications have not been met.

Scenario: (CH25) Allow users view their Gift card ballance.
Given I am on checkout page as User.
When I enter a valid gift card code.
And Click the Check Gift Card Status & Balance.
Then The Gift Card Status & Balance appears.
When I click on X remove link.
Then The Gift Card Status & Balance disappears.

Scenario: (CH26) Disallow users use invalid Gift cards.
Given I am on checkout page as User.
When I enter a invalid gift card code.
And Click the Add Gift Card button.
Then Message appears that the gift card is invalid

Scenario: (CH27) Allow users use their coupon codes.
Given I am on checkout page as User.
When I Enter a valid coupon code.
And Click the Apply Coupon button.
Then The coupon discount appears as a new line in the order summary and the grand total is updated.
And Message appears AutoTestCoupon (12345) has been applied to your order.