Meta:

Narrative:
Allow Users enter and edit checkout information.

Scenario: (CH19) Allow users enter faster their shipping information.
Given I am on checkout page as User.
When I check check-box Ship to My Billing Address.
Then It copies the data from the Billing Address form fields into the Shipping address form fields.

Scenario: (CH22) Allow Customers save entered address in Address book.
Given I am on checkout page as Customer and process checkout with checked Save in Address Book checkbox.
Then I can see entered on checkout page address in address book

Scenario: (CH21) Allow Users clarify information about Security code.
Given I am on checkout page as User and choose payment by Credit cart.
Then I can click on link What is this?
And It is associated with a form field triggers a tab tip popup with a description or explanation of the form field.

Scenario: (CH18) Allow customers log in on Checkout page.
Given I am on checkout page as User.
When I click on link Already Registered
And Enter valid data.
And Click login button.
Then I become logged in without leaving the page.

Scenario: (CH51) Users can subscribes to SMS Marketing messages (phase 2).
Given I am on checkout page as User.
When I check SMS Marketing Signup.
Then Triggers a partial page refresh through which a form field for mobile phone number displays.

Scenario: (CH20) Interac displays only for orders that are billed to Canadian addresses.
Given I am on checkout page as User.
Then I can see "2" payment methods.
When I enter Canadian billing address.
Then I can see "3" payment methods.

