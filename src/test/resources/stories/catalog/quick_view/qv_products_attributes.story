Meta:

Narrative:
Allow user to view products with different combinations of attributes.

Scenario: (CA51) Simple products can be available in one size or color (or any other attribute) only.
Given I am on QV with simple product.
Then I should see disabled block that shows availability by one size or color (or any other attribute) only.
And There are no variations to select or options to configure.

Scenario: (CA52) Simple products can be available without any additional attributes.
Given I am on QV with simple product.
Then I shouldn't see any blocks with attributes.
And Quantity field is populated with a quantity of 1 by default.