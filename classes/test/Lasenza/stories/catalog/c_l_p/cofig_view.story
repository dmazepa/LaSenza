Meta:

Narrative:
Allow users configure view in grid.

Scenario: User can see pagination and can move to other pages.
Given I am on Category page as User.
Then I can see only right arrow in pagination.
When I click on second page.
Then Second page with products opens.
Then I can see left and right arrows in pagination.
Then I can see second page is selected.

Scenario: User can't see left arrow on last page of pagination.
Given I am on Category page as User.
When I click on last page in pagination.
Then I can see only left arrow in pagination.

Scenario: User can move between pages using left and right arrows.
Given I am on Collection landing page as User.
When I click on right arrow.
Then I get second page.
When I click on left arrow.
Then I get first page.

Scenario: User can choose how many products to show on CLP.
Given I am on SubCategory page as User.
Then I can see 9 items on page.
When I select to show 15 items per page.
Then I get page with 15 items.
Then Quantity of pages is recalculated.
When I select to show 30 items per page.
Then I get page with 30 items.
Then Quantity of pages is recalculated.

Scenario: User can choose how sort products on CLP.
Given I am on SubCategory page as User.
Then I can see sorting by Best Value.
When I select sorting by Name [A to Z].
Then I get page sorting by Name [A to Z].
When I select sorting by Name [Z to A].
Then I get page sorting by Name [Z to A].
When I select sorting Price [Low to High].
Then I get page sorting Price [Low to High].
When I select sorting by Price [High to Low].
Then I get page sorting by Price [High to Low].