Meta:

Narrative:
Header Elements independent state.

Scenario: Link Store Locator redirects to the Store Locator page.
Given I am on home page
When I click on link Store Locator.
Then I should redirects to the Store Locator page.

Scenario: Allow user to enter text into search field.
Given I am on home page.
When I click on the search input field.
Then default text removes.
And I can enter the text.

Scenario: Magnifying glass icon performs the search and navigates users to a Search Results page
Given I am on home page.
And I enter text to search field.
When I click magnifying glass icon.
Then Search performs and navigates me to a Search Results page.

Scenario: Any element in Shopping cart area, when the shopping cart has items displays mini cart.
Given I am on home page.
And I have items in cart, one of them has qty more than 2.
When I click on any element in Shopping cart area.
Then I should see mini cart.
And Total number of items in cart equal sum of all qtys for each items.

Scenario: My Cart link, when the shopping cart is empty, redirects to Shopping cart page.
Given I am on home page.
And I have not items in cart.
When I click on My Cart link.
Then I should not see mini cart.
And I should redirects to Shopping cart page