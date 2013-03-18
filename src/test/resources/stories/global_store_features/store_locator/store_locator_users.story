Meta:

Narrative:
Allow the ability to effectively show stores in an easily searchable manner using Google Maps.

Scenario: (GSF21) Input field "Address" recognizes any search term that Google Maps understands, including exact addresses, location names, landmark names, zip codes, city/state/province/country names, etc.
Given I am on Store Locator page.
When I enter search term "Abbotsford Canada" into Address field.
Then Input field recognizes any search term that Google Maps understands.

Scenario: (GSF22) Users can specify a search radius and search locations.
Given I am on Store Locator page.
When I enter search term "32900 SOUTH FRASER WAY" into Address field.
When I specify a search radius "200".
And Click button search.
Then Only locations that fall within the selected radius will be returned in the search result.

Scenario: (GSF24) Search gives no results.
Given I am on Store Locator page.
When I enter search term "text, 12" into Address field.
And Click button search.
Then The area to the left of the map indicates No results found.

Scenario: (GSF25) Allow users clear entered search terms by one click.
Given I am on Store Locator page.
When I enter search term "text, 12" into Address field.
When I click Reset button.
Then Address field clears.

Scenario: (GSF26) Allow users to view all available stores.
Given I am on Store Locator page.
Then Search Results Sidebar displays all available stores.

Scenario: (GSF27) Allow users displays a list of turn by turn directions below the store location.
Given I am on Store Locator page.
When I click on direction.
Then Displays a list of turn by turn directions below the store location in the sidebar and updates the map with route line(s).

Scenario: (GSF28) Allow users clear all actions on Store Locator page.
Given I am on Store Locator page with some previous actions.
When I click link Reset Locations.
Then Restores the page to its initial load state where all available store locations are displayed in the sidebar.

Scenario: (GSF23) For the incorrect address appropriate error message displays.
Given I am on Store Locator page.
When I enter search term "" into Address field.
And Click button search.
Then A popup displays to indicate that The address is not valid.
