Meta:

Narrative:
User can use Color Swatches on the PDP.

Scenario: Large Color Swatch Displayed on Hover.
Given I am on PDP with configurable product as User.
When I hovers my mouse over a color swatch.
Then Larger image displays in an overlay.

Scenario: Images changes on click.
Given I am on PDP with configurable product as User.
When I clicks a color swatch.
Then The product image changes to display the color variant selected (when available).