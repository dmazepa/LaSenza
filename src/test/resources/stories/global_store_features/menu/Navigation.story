Meta:

Narrative:
As User, I want to be able navigate through store by menu.

Scenario: (GSF10) I can navigate to SubCLP by menu.
Given I am on home page
When I click on SubCLP link in menu "Push-Up".
Then I should go to SubCLP "Push-Up".

Scenario: (GSF11) I can navigate to Collection detail page by menu.
Given I am on CLP.
When I click on Collection "The Show Off" link in menu.
Then I should go to "The Show Off" Collection detail page.

Scenario: (GSF12) I can navigate to CLP by menu.
Given I am on CP.
When I click on "View all Bras" link in menu.
Then I should go to "Bras" CLP.

Scenario: (GSF13) I can navigate to CP by menu.
Given I am on CLP.
When I click on "View all Collections" link in menu.
Then I should go to "Collections" CLP.

Scenario: (GSF14) I can navigate to SubCLP with featured products by menu.
Given I am on home page
When I click on "View all featured" link in menu.
Then I should go to chosen SubCLP with featured products.

Scenario: (GSF15) I can navigate to SubCLP with single static block by menu.
Given I am on home page
When I click on View All Offers link in menu "beauty".
Then I should go to chosen SubCLP with single static block.

Scenario: (GSF16) I can navigate to SubCLP with static block and left navigation by menu.
Given I am on home page
When I click on View All Offers link in menu "sleepwear".
Then I should go to chosen SubCLP with static block and left navigation.

Scenario: (GSF17) On mouse over dropdown menu appears if available.
Given I am on home page
When I move mouse to the category with dropdown menu.
Then I should see dropdown menu.