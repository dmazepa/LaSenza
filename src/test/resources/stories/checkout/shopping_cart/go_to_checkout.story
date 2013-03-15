Meta:

Narrative:
Allow users go to the checkout from Shopping cart.

Scenario: (CH17) Users can go to checkout process.
Given I am on shopping cart as User with configurable product in cart.
When I click on checkout button in <Element> area in the shopping cart.
Then I come to the first step of checkout process.

Examples:
|Element
|page-title title-buttons
|totals
