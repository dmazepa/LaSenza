Meta:

Narrative:
Represent users cross-sells products and allow adding them to cart.

Scenario: Manager can configure manually this products.
Given I am in admin panel.
When I configure cross-sells products manually.
Then Configured products shows on Shopping cart page.

Scenario: Manager can configure cross-sells products based on rules.
Given I am in admin panel.
When I configure cross-sells products based on rules.
Then Configured products shows on Shopping cart page.

Scenario: Manager can configure cross-sells products that will be pulled, in a specified order, from a selected category.
Given I am in admin panel.
When I configure cross-sells to shows in a specified order.
Then Configured products shows on Shopping cart page.

Scenario: Allow users add to cart Cross-Sells products from shopping cart.
Given I am on Shopping cart with Cross-Sells products.
When Clicking on the product image or the product name.
Then Displays a Quickview module.
When I add to cart product.
Then Item adds to cart without leaving the page.