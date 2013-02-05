Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Define sequence in which user must select attributes.
Given I am on QW with configurable product as User.
When I select color in first row.
Then Select for attribute size enables.
When Set QTY for row "1" value "10".
When I add 2 additional product rows.
Then Qty field for third row pre-filled with value 1.

