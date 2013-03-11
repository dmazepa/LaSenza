Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Allow users use their Gift card.
Given I am on checkout page as User.
When I enter a valid gift card code.
And Click the Add Gift Card button.
Then The gift card "02104532110" discount appears as a new line in the order summary and the grand total is updated.