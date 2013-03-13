Meta:

Narrative:
Show for users Product Recommendations Carousel (Up-Sells).

Scenario: (CA13) Allow users slide products.
Given I am on PDP with product, that has Up-Sells.
When Click the forward arrow.
Then 3 products replaces with the next 3 products in the list.
When Click the backward arrow.
Then 3 products replaces with the previous 3 products in the list.

Scenario: (CA14) Allow users add Up-Sell products via QV module.
Given I am on PDP with product, that has Up-Sells.
When Clicking on the product image or the brand/product name.
Then Displays a Quickview module.
When I add to cart product.
Then Item adds to cart without leaving the page.