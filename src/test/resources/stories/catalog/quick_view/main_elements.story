Meta:

Narrative:
User could get a “quick view” of the product without needing to click through to the full product page.

Scenario: (CA38) I should see and can change main image for products with more then one image.
Given I am on QV with more then one image.
When I choose thumbnail image.
Then I should see chosen image instead main.
And I can see more then one thumbnail image.

Scenario: (CA39) I shouldn't see thumbnail images on QV for product, that has one image.
Given I am on QV with one image.
And I shouldn't see thumbnail images.
When I click Close Button.
Then QV module should close.

Scenario: (CA40) Customers can also close the Quickview module through their keyboard's Escape key.
Given I am on QV.
When I send Escape key.
Then QV module should close.

Scenario: (CA41) Customers can also close the Quickview module by clicking outside of the Quickview window.
Given I am on QV.
When I clicking outside of the Quickview window.
Then QV module should close.

Scenario: (CA42) Clicking on Brand Name/Product Name/View Full Details closes the Quickview module and navigates customers to the PDP.
Given I am on QV.
When I Clicking on <Element>.
Then QV module should close and customer navigates to the PDP.

Examples:
|Element
|Brand Name
|Product Name
|View Full Details