Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: (CH02) Allow users make last-minute changes to product attributes such as size and color without leaving the Shopping Cart page.
Given I am on shopping cart as User with simple product in cart.
When I click on <Element>.
Then Quickview displays.
And I can edit product attributes.
And Come back to Shopping cart page.

Examples:
|Element
|brand-name
|product-name
|product-image
|edit
