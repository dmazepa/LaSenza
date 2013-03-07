Meta:

Narrative:
As seller I want to allow users edit and see information of products in shopping cart through mini cart.

Scenario: (GSF55) Allow users to edit products in cart.
Given I am on home page with products in cart.
When I slide down mini cart.
And Click on link Edit Item.
Then I redirects to appropriate PDP and Add to Cart button has been replaced with an Update Cart button.
And I can edit item.

Scenario: (GSF56) Allow users to remove products from cart.
Given I am on home page with products in cart.
When I slide down mini cart.
And Click on link Remove Item.
And Accept confirmation.
Then Product removes from shopping cart.
And Mini cart updates and total count of products updated in header.

Scenario: (GSF57) Allow users refuse removing product from cart.
Given I am on home page with products in cart.
When I slide down mini cart.
And Click on link Remove Item.
And Refuse confirmation.
Then Product do not removes from shopping cart.
And The mini-cart remains open.

Scenario: (GSF58) Allow users go to the Shopping cart page.
Given I am on home page with products in cart.
When I slide down mini cart.
And Click on link Go to Shopping Cart.
Then The mini-cart closes.
And I redirects to the Shopping cart page.

Scenario: (GSF59) Allow guests go to the Checkout.
Given I am on home page with products in cart.
When I slide down mini cart.
And Click on link Checkout.
Then I redirects to the first step of checkout process for guest.

Scenario: (GSF60) Allow customers go to the Checkout.
Given I am on home page with products in cart as customer.
When I slide down mini cart.
And Click on link Checkout.
Then I redirects to the first step of checkout process for customer.

Scenario: (GSF54) Product Image/Brand Name/Product Name in mini cart should redirects to PDP.
Given I am on home page with products in cart.
When I slide down mini cart.
And Click on Product <Element>
Then I redirects to appropriate PDP.

Examples:
|Element
|product-image
|brand-name
|product-name