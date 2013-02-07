Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: User can choose how sort products on CLP.
Given I am on SubCategory page as User.
Then I can see sorting by "Best Value".
When I select sorting by Name [A to Z].
Then I get page sorting by Name [A to Z].
When I select sorting by Name [Z to A].
Then I get page sorting by Name [Z to A].
When I select sorting Price [Low to High].
Then I get page sorting Price [Low to High].
When I select sorting by Price [High to Low].
Then I get page sorting by Price [High to Low].