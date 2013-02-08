Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Prepare Base.
Given Prepare_base

Scenario: Prepare Base.
Given Check products inventory

Scenario: Allow Customers save entered address in Address book.
Given I am on checkout page as Customer and process checkout with checked Save in Address Book checkbox.
Then I can see entered on checkout page address in address book

Scenario: Allow Users clarify information about Security code.
Given I am on checkout page as User and choose payment by Credit cart.
Then I can click on link What is this?
And It is associated with a form field triggers a tab tip popup with a description or explanation of the form field.
