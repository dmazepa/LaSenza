Meta:

Narrative:
Allow users to add product to wishlist from QV.

Scenario: (CA54) Allow Users not logged in or does not has account add product to wishlist from QV.
Given I am on QV with configurable product as User.
When I click Add to Wishlist button User.
Then Quickview module closes and she is navigated to the Account Creation page.

Scenario: (CA53) Allow Customers add product to wishlist from QV.
Given I am on QV with configurable product as customer.
When I click Add to Wishlist button.
Then Quickview module closes and adds the product to her wishlist.