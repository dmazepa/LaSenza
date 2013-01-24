Meta:

Narrative:
Users can purchase multiple variants of a product from the Quickview.

Scenario: Manager can configurate number of rows that appears.
Given I am in admin panel.
When I configured number of rows that appears on QW.
Then Configured number of rows appears on QW.

Scenario: Two rows of attributes appears by default.
Given I am on QW with configurable product as User.
Then Select for attribute color is disable.
Then Qty field for first row pre-filled with value 1.
Then Qty field for second row doesn't pre-filled.
Then Two rows of attributes appears by default.

Scenario: Define sequence in which user must select attributes.
Given I am on QW with configurable product as User.
When I select size in first row.
Then Select for attribute color enables.
When I select size in second row.
Then The quantity input box updates to display a quantity of 1

Scenario: User can add more than two rows to the Product Selections area.
Given I am on QW with configurable product as User.
When I click on the plus sign or the "Add More Items" link.
Then Additional row adds to the Product Selections area.
Then Quantity input box for the new row will be pre-ﬁlled with a quantity of 1.

