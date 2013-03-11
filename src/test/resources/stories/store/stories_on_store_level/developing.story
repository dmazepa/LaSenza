Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Interac displays only for orders that are billed to Canadian addresses.
Given I am on checkout page as User.
Then I can see "3" payment methods.
When I enter Canadian billing address.
Then I can see "3" payment methods.