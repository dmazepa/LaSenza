Meta:

Narrative:
Allow Users use his discounts and view shipping/tax information.

Scenario: (CH13) Users can view shipping and tax information depended of entered data.
Given I am on shopping cart as User with configurable product in cart.
When I enter data to shipping carriers.
And Click on button Get a Quote.
Then Associated costs based upon the location information provided in the Estimate Shipping and Tax form.
When I select a shipping option and click the Update Total button.
Then Shipping and Sales Tax charges appear as separate lines in the order summary and the grand total is updated.
When I go to checkout page.
Then This information is remembered within the checkout form

Scenario: (CH12) Allow users view their Gift card ballance.
Given I am on shopping cart as User with configurable product in cart.
When I enter a valid gift card code.
And Click the Check Gift Card Status & Balance shopping cart.
Then The Gift Card Status & Balance appears.
When I click on X remove link.
Then The Gift Card Status & Balance disappears.