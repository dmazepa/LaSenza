Meta:

Narrative:
As a user
I want to pass checkout with different preconditions

Scenario: Passing checkout via PayPal.
Given I am on checkout page as User.
When I pass checkout with via PayPal.
Then I get Thank You Page.

Scenario: Passing checkout with different carts.
Given I am on checkout page as User.
When I pass checkout with <nameCart>, that has number <numberCart>, cart type <value> security code <securityCode>.
Then I get Thank You Page.
Examples:
|nameCart               |numberCart         |securityCode   |value
|Visa                   |4242424242424242   |123            |VI
|Mastercard             |5454545454545454   |123            |MC
|American Express       |373599005095005    |123            |AE

