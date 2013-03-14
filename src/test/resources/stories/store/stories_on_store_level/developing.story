Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: (CH13) Users can view shipping and tax information depended of entered data.
Given I am on shopping cart as User with configurable product in cart.
When I enter data to shipping carriers.
And Click on button Get a Quote.
Then Associated costs based upon the location information provided in the Estimate Shipping and Tax form.
When I select a shipping option and click the Update Total button.
Then Shipping and Sales Tax charges appear as separate lines in the order summary and the grand total is updated.
When I go to checkout page.
Then This information is remembered within the checkout form