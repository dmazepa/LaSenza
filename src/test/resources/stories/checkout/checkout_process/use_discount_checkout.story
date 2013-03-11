Meta:

Narrative:
Allow Users use his discounts.

Scenario: Allow user use his Prestige Loyalty Card.
Given I am on checkout page as User.
When Enter a Prestige Card number into the field.
And Click Apply.
Then The discount will be reflected in the Order Summary box.

Scenario: Allow users use their coupon codes.
Given I am on checkout page as User.
When I Enter a valid coupon code.
And Click the Apply Coupon button.
Then The coupon discount appears as a new line in the order summary and the grand total is updated.
And Message appears AutoTestCoupon (12345) has been applied to your order.

Scenario: Disallow users use their invalid coupon codes.
Given I am on checkout page as User.
When I Enter a invalid coupon code.
And Click the Apply Coupon button.
Then message appears: “<promo code name> is invalid or qualifications have not been met”.

Scenario: Allow users use their Gift card.
Given I am on checkout page as User.
When I enter a valid gift card code.
And Click the Add Gift Card button.
Then The gift card "02104532110" discount appears as a new line in the order summary and the grand total is updated.

Scenario: Allow users view their Gift card ballance.
Given I am on checkout page as User.
When I enter a valid gift card code.
And Click the Check Gift Card Status & Balance.
Then The Gift Card Status & Balance appears.
When I click on X remove link.
Then The Gift Card Status & Balance disappears.

Scenario: Disallow users use invalid Gift cards.
Given I am on checkout page as User.
When I enter a invalid gift card code.
And Click the Add Gift Card button.
Then Message appears that the gift card is invalid

Scenario: Allow users pay for all products in cart using only Gift cart.
Given I am on checkout page as User.
When I enter a invalid gift card code, that has balance more than cart Total.
And Click the Add Gift Card button.
Then The Payment Method section is disabled
Then The gift card "02104532101" discount appears as a new line in the order summary and the grand total is updated.

Scenario: Disallow users to buy Gift cart using another gift cart.
Given I am on checkout as User with gift cart product in cart.
Then I can't apply gift cart to cart.

Scenario: Do not save in checkout session applied gift cards, if user add gift card to basket.
Given I am on checkout page as User.
When I enter a valid gift card code.
And Click the Add Gift Card button.
When I add to cart gift cart product and return to shopping cart.
Then I can't see previous applied gift cards.
