Meta:

Narrative:
As User, I want to be able navigate through store by menu.

Scenario: I can navigate to SubCLP by menu.
Given I am on home page
When I click on SubCLP link in menu.
Then I should go to chosen SubCLP.

Scenario: I can navigate to Collection detail page by menu.
Given I am on CLP.
When I click on Collection link in menu.
Then I should go to chosen Collection detail page.

Scenario: I can navigate to CLP by menu.
Given I am on CP.
When I click on View All (in Category)link in menu.
Then I should go to chosen CLP.

Scenario: I can navigate to CP by menu.
Given I am on SubCLP.
When I click on View All Collections link in menu.
Then I should go to chosen CP.

Scenario: I can navigate to SubCLP with featured products by menu.
Given I am on Home page.
When I click on View All Featured link in menu.
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