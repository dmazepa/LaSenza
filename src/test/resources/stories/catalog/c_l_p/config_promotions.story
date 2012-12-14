Meta:

Narrative:
Merchants can configure promotions.

Scenario: Merchants can tailor promotions or messaging to the category.
Given I am in admin panel.
When I configure promotions or messaging to the category.
Then I can see configured static block on appropriate category.

Scenario: Merchants can configure products flags to show users.
Given I am in admin panel.
When I configure product flag
Then It displays on CLP.