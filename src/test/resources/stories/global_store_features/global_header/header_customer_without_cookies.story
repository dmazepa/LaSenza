Meta:

Narrative:
Header for customer without cookies enabled.

Scenario: Welcome message for customer.
Given I am on home page as customer.
Then I should see string "WELCOME BACK TEST TESTER"

Scenario: Link Log Out logs out customer and load default header state.
Given I am on home page as customer.
When I click on link Log Out.
Then It logs customer out.
And Load default header state.

Scenario: Link My Account redirects to the My Account Dashboard page.
Given I am on home page as customer.
When I click on link My Account.
Then I should redirects to the My Account Dashboard page.

Scenario: Total count of items in Wish list should displays for customers.
Given I am on Home page as customer and has multiple wishlists and items in Wish List.
Then Total count of items in Wish list should displays.
Then The same item from different wish lists is counted multiple times.

Scenario: Link Wish List for customer redirects to My Wishlist page.
Given I am on home page as customer.
When I click on link Wish List.
Then I should redirects to the My Wishlist page.