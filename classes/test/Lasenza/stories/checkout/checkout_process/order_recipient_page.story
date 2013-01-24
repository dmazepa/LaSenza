Meta:

Narrative:
Order Recipient page

Scenario: Show to user appropriate information about order and allow to return to the Home page.
Given I am on Order Recipient page.
Then I can see appropriate information about order.
And I can return to Home page.


Scenario: Interac displays only for orders that are billed to Canadian addresses.
Given I am on checkout page as User.
Then I can see Three payment methods.
When I enter Canadian billing address.
Then All four payment methods appears.

