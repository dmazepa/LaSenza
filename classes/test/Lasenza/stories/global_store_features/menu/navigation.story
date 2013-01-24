Meta:

Narrative:
As User, I want to be able navigate through store by menu.

Scenario: I can navigate to SubCLP by menu.
Given I am on home page
When I click on SubCLP link in menu "Push-Up".
Then I should go to SubCLP "Push-Up".

Scenario: I can navigate to Collection detail page by menu.
Given I am on CLP.
When I click on Collection "The Show Off" link in menu.
Then I should go to "The Show Off" Collection detail page.

Scenario: I can navigate to CLP by menu.
Given I am on CP.
When I click on "View all Bras" link in menu.
Then I should go to "Bras" CLP.

Scenario: I can navigate to CP by menu.
Given I am on CLP.
When I click on "View all Collections" link in menu.
Then I should go to "Collections" CLP.

Scenario: I can navigate to SubCLP with featured products by menu.
Given I am on home page
When I click on "View all featured" link in menu.
Then I should go to chosen SubCLP with featured products.

Scenario: I can navigate to SubCLP with single static block by menu.
Given I am on Home page.
When I click on View All Offers link in menu.
Then I should go to chosen SubCLP with single static block.

Scenario: I can navigate to SubCLP with static block and left navigation by menu.
Given I am on Home page.
When I click on View All Offers link in menu.
Then I should go to chosen SubCLP with static block and left navigation.

Scenario: On mouse over dropdown menu appears if available.
Given I am on home page
When I mouse one of the category with dropdown menu.
Then I should see dropdown menu.