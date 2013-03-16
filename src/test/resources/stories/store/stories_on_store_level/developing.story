Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: (MA08) Allow customers remember his password.
Given I am on Login page.
When I use process forgot my password.
Then I get email with new password.
And I can log in with new password.
