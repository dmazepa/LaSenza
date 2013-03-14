Meta:

Narrative:
Allow users edit products in shopping cart.

Scenario: (CH01) Show to user message about changes, that he done.
Given I am on shopping cart as User with simple product in cart.
And Edit item link does not shows for simple products.
When I click on Update Shopping Cart button after making changes to the item quantity.
Then Product Updated Message displays.
And It updates the item subtotal and order totals through a partial page refresh.

Scenario: (CH03) Users can remove items from cart.
Given I am on shopping cart as User with simple product in cart.
When I click on remove item icon.
Then Item removes from the shopping cart.

Scenario: (CH04) Allow users fast come back to the Home Page.
Given I am on shopping cart as User with simple product in cart.
When I click on Continue Shopping.
Then It returns user to Home page.

Scenario: (CH05) Allow users fast come back to the Home Page from empty shopping cart.
Given I am on empty shopping cart as User.
When I click on link Click here.
Then It returns user to Home page.

Scenario: (CH06) Allow users fast clearing shopping cart.
Given I am on shopping cart as User with simple product in cart.
When I click on Clear Shopping Cart.
Then It removes all items from the shopping cart.

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
