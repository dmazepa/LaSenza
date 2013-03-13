Meta:

Narrative:
Users can Complete the Outfit of selected item using Matchbacks on PDP.

Scenario: (CA15) Manager can configurate number of rows that appears.
Given I am in admin panel.
When I configured promotion message.
When I configured related products.
Then Configured promotion message appears.
And Configured related products appears and they equal to the count in promotional message.

Scenario: (CA16) Two rows of attributes appears by default.
Given I am on PDP with Complete the Outfit block.
Then Select for attribute color is disable.
Then Qty field for first row pre-filled with value 1.
Then Qty field for second row doesn't pre-filled.
Then Two rows of attributes appears by default.

Scenario: (CA17) Define sequence in which user must select attributes.
Given I am on PDP with Complete the Outfit block (configurable).
When I select size in first row for outfit product.
Then Select for attribute color enables.
When I select size in second row.
Then The quantity input box updates to display a quantity of 1

Scenario: (CA18) User can add more than two rows to the Product Selections area for Outfit products.
Given I am on QV with with Complete the Outfit block (simple).
When I click on the plus sign or the "Add More Items" link for Outfit.
Then Additional row adds to the Product Selections area.
Then Quantity input box for the new row will be pre-ﬁlled with a quantity of 1.
And I can add them to cart.