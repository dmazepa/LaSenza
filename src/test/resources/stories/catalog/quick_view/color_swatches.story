Meta:

Narrative:
User can use Color Swatches on the QW.

Scenario: Large Color Swatch Displayed on Hover.
Given I am on QW with configurable product as User.
When I hovers my mouse over a color swatch.
Then Larger image displays in an overlay.

Scenario: Images changes on click.
Given I am on QW with configurable product as User.
When I clicks a color swatch.
Then the product image changes to display the color variant selected (when available).