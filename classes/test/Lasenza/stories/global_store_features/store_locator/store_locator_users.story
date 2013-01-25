Meta:

Narrative:
Allow the ability to effectively show stores in an easily searchable manner using Google Maps.

Scenario: Input field "Address" recognizes any search term that Google Maps understands, including exact addresses, location names, landmark names, zip codes, city/state/province/country names, etc.
Given I am on Store Locator page.
When I enter search term into "Address" field.
Then Input field recognizes any search term that Google Maps understands.

Scenario: Users can specify a search radius and search locations.
Given I am on Store Locator page.
And I enter search term into "Address" field.
When I specify a search radius.
And click button search.
Then Only locations that fall within the selected radius will be returned in the search result.

Scenario: For the incorrect address appropriate error message displays.
Given I am on Store Locator page.
When I enter incorrect search term into "Address" field.
And click button search.
Then A popup displays to indicate that "The address is not valid".

Scenario: Search gives no results.
Given I am on Store Locator page.
When I enter search term into "Address" field.
And click button search.
Then The area to the left of the map indicates "No results found".

Scenario: Allow users clear entered search terms by one click.
Given I am on Store Locator page.
And I enter search term into "Address" field.
When I click Reset button.
Then Address field clears.

Scenario: Allow users to view all available stores.
Given I am on Store Locator page.
Then Search Results Sidebar displays all available stores.

Scenario: Allow users view store more detail on map.
Given I am on Store Locator page.
When I click on store entry.
Then The map centers on the store location and a popup window displays on the map next to store's pinned location.
And Popup contains all additional information designated by the administrator.

Scenario: Allow users displays a list of turn by turn directions below the store location.
Given I am on Store Locator page.
When I click on direction.
Then Displays a list of turn by turn directions below the store location in the sidebar and updates the map with route line(s).
And the user will be shown a closer view of that section of the route on the map.

Scenario: Allow users clear all actions on Store Locator page.
Given I am on Store Locator page with some previous actions.
When I click link Reset Locations.
Then restores the page to its initial load state where all available store locations are displayed in the sidebar and on the map.