Meta:

Narrative:
Users can purchase multiple variants of a product from the PDP.

Scenario: (CA11) Define sequence in which user must select attributes.
Given I am on PDP with configurable product as User.
When I select color in first row.
Then Select for attribute size enables.
Then I can select color in second row.

Scenario: (CA12) User can add more than two rows to the Product Selections area.
Given I am on PDP with configurable product as User.
When Set QTY for row "1" value "11".
When I click on the plus sign or the Add More Items link.
Then Additional row adds to the Product Selections area.
Then Qty field for third row pre-filled with value 1.

Scenario: (CA09) Manager can configurate number of rows that appears.
Given I am in admin panel
When I configured number of rows that appears on PDP.
Then Configured number of rows appears on PDP.

Scenario: (CA10) Two rows of attributes appears by default.
Given I am on PDP with configurable product as User.
Then Select for attribute size is disable.
Then Qty field for "1" row pre-filled with value "1".
Then Two rows of attributes appears by default.
Then Qty field for second row doesn't pre-filled.

