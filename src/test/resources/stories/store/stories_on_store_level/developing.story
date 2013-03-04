Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Total count of items in Wish list should displays for customers.
Given I am on Home page as customer and has multiple wishlists and items in Wish List.
Then Total count of items in Wish list should displays.
Then The same item from different wish lists is counted multiple times.
