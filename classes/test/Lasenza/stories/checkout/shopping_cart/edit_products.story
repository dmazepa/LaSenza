Meta:

Narrative:
Allow users edit products in shopping cart.

Scenario: Show to user message about changes, that he done.
Given I am on shopping cart as User with some products in cart.
And Edit item link does not shows for simple products.
When I click on Update Shopping Cart button after making changes to the item quantity.
Then Product Updated Message displays.
And It updates the item subtotal and order totals through a partial page refresh.

Scenario: Allow users make last-minute changes to product attributes such as size and color without leaving the Shopping Cart page.
Given I am on shopping cart as User with some products in cart.
When I click on Brand Name, Product Name, Product Image, Edit product.
Then Quickview displays.
And I can edit product attributes.
And Come back to Shopping cart page.

Scenario: Users can remove items from cart.
Given I am on shopping cart as User with some products in cart.
When I click on remove item icon.
Then Item removes from the shopping cart without full page refresh.

Scenario: Allow users fast come back to the Home Page.
Given I am on shopping cart as User with some products in cart.
When I click on Continue Shopping.
Then It returns user to Home page.

Scenario: Allow users fast come back to the Home Page from empty shopping cart.
Given I am on empty shopping cart as User.
When I click on link Click here.
Then It returns user to Home page.

Scenario: Allow users fast clearing shopping cart.
Given I am on shopping cart as User with some products in cart.
When I click on Clear Shopping Cart.
Then It removes all items from the shopping cart.