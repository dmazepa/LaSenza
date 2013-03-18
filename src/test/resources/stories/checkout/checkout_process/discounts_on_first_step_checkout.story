Meta:

Narrative:
Allow Users use his discounts.

Scenario: (CH23) Allow user use his Prestige Loyalty Card.
Given I am on checkout page as User.
When Enter a Prestige Card number into the field.
And Click Apply.
Then The discount will be reflected in the Order Summary box.

Scenario: (CH24) Allow users use their Gift card.
Given I am on checkout page as User.
When I enter a valid gift card code.
And Click the Add Gift Card button.
Then The gift card "02104532109" discount appears as a new line in the order summary and the grand total is updated.

Scenario: (CH29) Allow users pay for all products in cart using only Gift cart.
Given I am on checkout page as User.
When I enter a valid gift card code, that has balance more than cart Total.
And Click the Add Gift Card button.
Then The Payment Method section is disabled
Then The gift card "02104532101" discount appears as a new line in the order summary and the grand total is updated.

Scenario: (CH30) Disallow users to buy Gift cart using another gift cart.
Given I am on checkout as User with gift cart product in cart.
Then I can't apply gift cart to cart.

Scenario: (CH31) Do not save in checkout session applied gift cards, if user add gift card to basket.
Given I am on checkout page as User.
When I enter a valid gift card code.
And Click the Add Gift Card button.
When I add to cart gift cart product and return to shopping cart.
Then I can't see previous applied gift cards.