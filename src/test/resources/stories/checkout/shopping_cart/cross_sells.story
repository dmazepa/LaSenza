Meta:

Narrative:
Represent users cross-sells products and allow adding them to cart.

Scenario: (CH14) Manager can configure manually this products.
Given I am in admin panel
When I configure cross-sells products manually.
Then Configured products "So Free Balconnet la" id "4189" shows on Shopping cart page.

Scenario: (CH15) Manager can configure cross-sells products based on rules.
Given I am in admin panel
When I configure cross-sells products based on rules.
Then Configured products "Modal Lightly Lined Bra with Red Point D'Esprit and Bows" id "3154" shows on Shopping cart page.

Scenario: (CH16) Allow users add to cart Cross-Sells products from shopping cart.
Given I am on Shopping cart with Cross-Sells products.
When Clicking on the product image or the product name.
Then Pop-up displays.
When I add to cart product.
Then Item adds to cart without leaving the page.