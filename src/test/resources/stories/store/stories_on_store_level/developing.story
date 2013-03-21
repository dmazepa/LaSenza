Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: (CA32) User can multi filter products by Color swatcher.
Given I am on Category page as User.
When Clicking consistently on attribute refinement Color swatcher.
Then Its associated check-box places it in the "Currently Shopping By" list.
Then Dynamically filters both the list of remaining attribute refinements and the list of products returned

