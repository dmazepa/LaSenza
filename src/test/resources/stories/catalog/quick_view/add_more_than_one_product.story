Meta:

Narrative:
Users can purchase multiple variants of a product from the Quickview.

Scenario: (CA47) Manager can configurate number of rows that appears.
Given I am in admin panel
When I configured number of rows that appears on QV.
Then Configured number of rows appears on QV.

Scenario: (CA48) Two rows of attributes appears by default.
Given I am on QV with configurable product as User.
Then Select for attribute size is disable.
Then Qty field for "1" row pre-filled with value "1".
Then Two rows of attributes appears by default.

Scenario: (CA49) Define sequence in which user must select attributes.
Given I am on QV with configurable product as User.
When I select color in first row.
Then Select for attribute size enables.

Scenario: (CA50) User can add more than two rows to the Product Selections area.
Given I am on QV with configurable product as User.
When Set QTY for row "1" value "10".
When I add 2 additional product rows.
Then Qty field for third row pre-filled with value 1.

