Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Allow Users create account from Order Recipient page.
Given I am on checkout page as User.
When I create account.
Then I get account.

