Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: User can choose how many products to show on CLP.
Given I am on SubCategory page as User.
Then I can see "8" items on page.
When I select to show "16" items per page.
Then I get page with 16 items.
Then Quantity of pages is recalculated.
When I select to show 32 items per page.
Then I get page with 32 items.
Then Quantity of pages is recalculated.