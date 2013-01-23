Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Allow Customers save entered address in Address book.
Given I am on checkout page as Customer and process checkout with checked Save in Address Book checkbox.
Then I can see entered on checkout page address in address book

Scenario: Allow customers log in on Checkout page.
Given I am on checkout page as User.
When I click on link Already Registered
And Enter valid data.
And Click login button.
Then I become logged in without leaving the page.

Scenario: Show to users appropriate error message if he enter wrong password.
Given I am on checkout page as User.
When I create account and enter wrong password.
Then I get error message.

Scenario: Allow Users create account from Order Recipient page.
Given I am on checkout page as User.
When I create account.
Then I get account.

