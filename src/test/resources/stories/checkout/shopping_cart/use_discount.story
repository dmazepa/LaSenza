Meta:

Narrative:
Allow Users use his discounts and view shipping/tax information.

Scenario: (CH07) Allow user use his Prestige Loyalty Card.
Given I am on shopping cart as User with some products in cart.
When Enter a Prestige Card number into the field.
And Click Apply.
Then The discount will be reflected in the Order Summary box.

Scenario: (CH08) Allow user sign up to Prestige Loyalty Card.
Given I am on shopping cart as User with some products in cart.
When Click the Sign Up link.
Then It sends users to the Prestige Registration page.

Scenario: (CH09) Allow users use their coupon codes.
Given I am on shopping cart as User with some products in cart.
When I Enter a valid coupon code.
And Click the Apply Coupon button.
Then The coupon discount appears as a new line in the order summary and the grand total is updated.

Scenario: (CH10) Disallow users use their invalid coupon codes.
Given I am on shopping cart as User with some products in cart.
When I Enter a invalid coupon code.
And Click the Apply Coupon button.
Then Appropriate error messaging ("Coupon code "XXXXXXX" is not valid.") displays.

Scenario: (CH11) Allow users use their Gift card.
Given I am on shopping cart as User with some products in cart.
When I enter a valid gift card code.
And Click the Add Gift Card button.
Then The Gift Card Status & Balance appears.
Then The gift card discount appears as a new line in the order summary and the grand total is updated.

Scenario: (CH12) Allow users view their Gift card ballance.
Given I am on shopping cart as User with some products in cart.
When I enter a valid gift card code.
And Click the Check Gift Card Status & Balance.
Then The Gift Card Status & Balance appears.
When I click on X remove link.
Then The Gift Card Status & Balance disappears

Scenario: (CH13) Users can view shipping and tax information depended of entered data.
Given I am on shopping cart as User with some products in cart.
When I enter data to shipping carriers.
And Click on button Get a Quote.
Then Associated costs based upon the location information provided in the Estimate Shipping and Tax form.
When I select a shipping option and click the Update Total button.
Then Shipping and Sales Tax charges appear as separate lines in the order summary and the grand total is updated.
When I go to checkout page.
Then This information is remembered within the checkout form