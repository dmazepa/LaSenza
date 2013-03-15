Meta:

Narrative:
Allow Users use his discounts and view shipping/tax information.

Scenario: (CH07) Allow user use his Prestige Loyalty Card.
Given I am on shopping cart as User with configurable product in cart.
When Enter a Prestige Card number into the field.
And Click Apply.
Then The discount will be reflected in the Order Summary box.

Scenario: (CH08) Allow user sign up to Prestige Loyalty Card.
Given I am on shopping cart as User with configurable product in cart.
When Click the Sign Up link.
Then It sends users to the Prestige Registration page.

Scenario: (CH09) Allow users use their coupon codes.
Given I am on shopping cart as User with configurable product in cart.
When I Enter a valid coupon code shopping cart.
And Click the Apply Coupon button shopping cart.
Then The coupon discount appears as a new line in the order summary and the grand total is updated.

Scenario: (CH10) Disallow users use their invalid coupon codes.
Given I am on shopping cart as User with configurable product in cart.
When I Enter a invalid coupon code shopping_cart.
And Click the Apply Coupon button shopping cart.
Then Appropriate error messaging Coupon code XXXXXXX is not valid. displays.

Scenario: (CH11) Allow users use their Gift card.
Given I am on shopping cart as User with configurable product in cart.
When I enter a valid gift card code.
And Click the Add Gift Card button shopping cart.
Then The gift card "02104532109" discount appears as a new line in the order summary and the grand total is updated.
