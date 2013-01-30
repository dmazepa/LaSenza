Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Allow users create account.
Given I am on Login page.
When I use process to create account.
Then I get My Account: Dashboard page with logged in status.
And I get confirmation email.