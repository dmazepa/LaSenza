Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Allow Customers save entered address in Address book.
Given I am on checkout page as Customer and process checkout with checked Save in Address Book checkbox.
Then I can see entered on checkout page address in address book


