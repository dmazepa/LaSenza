Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Show to users appropriate error message if he enter wrong password.
Given I am on checkout page as User.
When I create account and enter wrong password.
Then I get error message.