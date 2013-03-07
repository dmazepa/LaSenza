Meta:

Narrative:
As User, I should see special blocks in menu.

Scenario: (GSF18) I shouldn't see collections in "SLEEPWEAR" menu.
Given I am on home page
When I move mouse on "sleepwear" menu.
Then I shouldn't see collections block.
And I should see static block instead collections.

Scenario: (GSF19) I should see special elements in "SALE" menu.
Given I am on home page
When I move mouse on "sale" menu.
Then I should see block with main categories.
And I should see 3 static blocks.