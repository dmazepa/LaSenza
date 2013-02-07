Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: I can navigate to SubCLP with static block and left navigation by menu.
Given I am on home page
When I click on View All Offers link in menu "sleepwear".
Then I should go to chosen SubCLP with static block and left navigation.