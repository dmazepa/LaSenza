Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Define sequence in which user must select attributes.
Given I am on PDP with configurable product as User.
When I select color in first row.
Then Select for attribute size enables.
When I select color in second row.
Then The quantity input box updates to display a quantity of 1


