Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: User can remove refinements in left navigation.
Given I am on Category page as User.
When I click on category refinement.
When I remove the refinement.
Then The list of categories display again.