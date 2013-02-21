Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Allow users add to cart Cross-Sells products from shopping cart.
Given I am on Shopping cart with Cross-Sells products.
When Clicking on the product image or the product name.
Then Pop-up displays.
When I add to cart product.
Then Item adds to cart without leaving the page.
