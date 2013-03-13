Meta:

Narrative:
Allow user to view left navigation more compactly.

Scenario: (CA37) User can expand and collapsed refinements
Given I am on Category page as User.
When Clicking the arrow to the right of the attribute title.
Then The arrow faces down when an attribute refinement group is expanded.
When Clicking the arrow to the right of the attribute title.
Then Faces to the right when collapsed.