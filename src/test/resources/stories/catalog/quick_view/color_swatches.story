Meta:

Narrative:
User can use Color Swatches on the QV.

Scenario: (CA43) Large Color Swatch Displayed on Hover.
Given I am on QV with configurable product as User.
When I hovers my mouse over a color swatch.
Then Larger image displays in an overlay.

Scenario: (CA44) Images changes on click.
Given I am on QV with configurable product as User.
When I clicks a color swatch.
Then The product image changes to display the color variant selected (when available).