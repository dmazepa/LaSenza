Meta:

Narrative:
Order Recipient page

Scenario: Show to user appropriate information about order and allow to return to the Home page.
Given I am on Order Recipient page.
Then I can see appropriate information about order.
And I can return to Home page.

Scenario: Allow Users create account from Order Recipient page.
Given I am on Order Recipient page as user.
When I create account.
Then I get My account page.

Scenario: Show to users appropriate error message if he enter wrong password.
Given I am on Order Recipient page as user.
When I create account and enter wrong password.
Then I get error message.