Meta:

Narrative:
Header Elements independent state.

Scenario: (GSF51) My Cart text in header, when the shopping cart is empty, should not show mini-cart and should not redirects to another page.
Given I am on home page.
And I have not items in cart.
When I click on My Cart link.
Then I should not see mini cart.
And I should stay on Home page.

Scenario: (GSF48) Link Store Locator redirects to the Store Locator page.
Given I am on home page
When I click on link Store Locator.
Then I should redirects to the Store Locator page.

Scenario: (GSF49) Magnifying glass icon performs the search and navigates users to a Search Results page
Given I am on home page.
And I enter "text1" to search field.
When I click magnifying glass icon.
Then Search performs and navigates me to a Search Results page.

Scenario: (GSF50) Any element in Shopping cart area, when the shopping cart has items displays mini cart.
Given I am on home page.
And I have items in cart, one of them has qty more than 2.
When I click on <Element> in Shopping cart area.
Then I should see mini cart.
And Total number of items in cart equal <sum> of all qtys for each items.

Examples:
|Element        |sum
|Icon Bag       |3
|QTY            |6
|Total Price    |9
