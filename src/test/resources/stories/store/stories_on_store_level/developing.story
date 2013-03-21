Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: (CA33) User can multi filter products by Price.
Given I am on Category page as User.
When Clicking consistently on attribute refinement Price.
Then Its associated check-box price places it in the Currently Shopping By list.
Then Dynamically filters both the list of remaining attribute refinements and the list of products returned
