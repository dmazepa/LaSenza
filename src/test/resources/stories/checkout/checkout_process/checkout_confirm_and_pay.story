Meta:

Narrative:
Show to user summary information on second checkout step.

Scenario: (CH34) Disallow users submit order with wrong information.
Given I am on second step of checkout process with invalid information.
Then Returns appropriate message.

Scenario: (CH33) Allow users come back to first step to edit order information.
Given I am on second step of checkout process with valid information.
When I click Submit button.
Then I get order confirmation page.

Scenario: (CH37) Show to users appropriate error message if he enter wrong password.
Given I am on checkout page as User.
When I create account and enter wrong password.
Then I get error message.

Scenario: (CH36) Allow Users create account from Checkout page.
Given I am on checkout page as User.
When I create account.
Then I get account.