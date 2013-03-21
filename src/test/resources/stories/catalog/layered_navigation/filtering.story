Meta:

Narrative:
Customers can also filter products by their attributes (e.g., Size, Color, Price, Collection, Featured, etc.).

Scenario: (CA31) User can filter products by Size.
Given I am on Category page as User.
Given I can see attribute refinements, number of products associated with each category appears near name.
Given Number of products associated with attribute color swatcher does not shows.
When Clicking an attribute refinement Size
Then Its associated check-box places it in the Currently Shopping By list.
Then Dynamically filters both the list of remaining attribute refinements and the list of products returned

Scenario: (CA32) User can multi filter products by Color swatcher.
Given I am on Category page as User.
When Clicking consistently on attribute refinement Color swatcher.
Then Its associated check-box for color places it in the Currently Shopping By list.
Then Dynamically filters both the list of remaining attribute refinements and the list of products returned

Scenario: (CA33) User can multi filter products by Price.
Given I am on Category page as User.
When Clicking consistently on attribute refinement Price.
Then Its associated check-box places it in the Currently Shopping By list.
Then Dynamically filters both the list of remaining attribute refinements and the list of products returned

Scenario: (CA34) User can filter products by Collection.
Given I am on Category page as User.
When Clicking an attribute refinement Collection.
Then Its associated check-box places it in the "Currently Shopping By" list.
Then Dynamically filters both the list of remaining attribute refinements and the list of products returned

Scenario: (CA35-CA36) User can filter products by Featured and remove all refinements by one click.
Given I am on Category page as User.
When Clicking an attribute refinement Featured.
Then Its associated check-box places it in the "Currently Shopping By" list.
Then Dynamically filters both the list of remaining attribute refinements and the list of products returned
When Click Clear All link below the list of selected refinements
Then Removes the refinement or refinements from the "Currently Shopping By" area.
Then Restores them to their original locations in the left navigation menu.