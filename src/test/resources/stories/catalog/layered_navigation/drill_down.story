Meta:

Narrative:
User can drill down deeper within category from the left navigation.

Scenario: (CA29) User can drill down deeper within category from the left navigation.
Given I am on Category page as User.
Given I can see category refinements, number of products associated with each category appears near name.
When I click on category refinement.
Then It removes the value from its original location.
Then Places it in the Currently Shopping By list.
Then Dynamically filters both the list of attribute refinements and the list of products returned.
Then Category list disappears.

Scenario: (CA30) User can remove refinements in left navigation.
Given I am on Category page as User.
When I click on category refinement.
When I remove the refinement.
Then The list of categories display again.