Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: User can add more than two rows to the Product Selections area.
Given I am on PDP with configurable product as User.
When Set QTY for row "1" value "11".
When I click on the plus sign or the Add More Items link.
Then Additional row adds to the Product Selections area.
Then Qty field for third row pre-filled with value 1.