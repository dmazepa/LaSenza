Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Allow users clear all actions on Store Locator page.
Given I am on Store Locator page with some previous actions.
When I click link Reset Locations.
Then Restores the page to its initial load state where all available store locations are displayed in the sidebar.