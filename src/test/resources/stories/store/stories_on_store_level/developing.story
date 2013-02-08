Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Product Image/Brand Name/Product Name in mini cart should redirects to PDP.
Given I am on home page with products in cart.
When I slide down mini cart.
And Click on Product <Element>
Then I redirects to appropriate PDP.

Examples:
|Element
|product-image
|brand-name
|product-name