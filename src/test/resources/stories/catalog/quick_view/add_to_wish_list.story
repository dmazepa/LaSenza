Meta:

Narrative:
Allow users to add product to wishlist from QW.

Scenario: Allow Customers add product to wishlist from QW.
Given I am on QW with configurable product as customer.
When I click Add to Wishlist button.
Then Quickview module closes and adds the product to her wishlist.

Scenario: Allow Users not logged in or does not has account add product to wishlist from QW.
Given I am on QW with gift cart product as User.
When I click Add to Wishlist button.
Then Quickview module closes and she is navigated to the Account Creation page.