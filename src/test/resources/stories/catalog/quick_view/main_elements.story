Meta:

Narrative:
User could get a “quick view” of the product without needing to click through to the full product page.

Scenario: I should see and can change main image for products with more then one image.
Given I am on QW with more then one image.
When I choose thumbnail image.
Then I should see chosen image instead main.
And I can see more then one thumbnail image.

Scenario: I shouldn't see thumbnail images on QW for product, that has one image.
Given I am on QW with one image.
And I shouldn't see thumbnail images.
When I click Close Button.
Then QW module should close.

Scenario: Customers can also close the Quickview module through their keyboard's Escape key.
Given I am on QW.
When I send Escape key.
Then QW module should close.

Scenario: Customers can also close the Quickview module by clicking outside of the Quickview window.
Given I am on QW.
When I clicking outside of the Quickview window.
Then QW module should close.

Scenario: Clicking on Brand Name/Product Name/View Full Details closes the Quickview module and navigates customers to the PDP.
Given I am on QW.
When I Clicking on <Element>.
Then QW module should close and customer navigates to the PDP.

Examples:
|Element
|Brand Name
|Product Name
|View Full Details