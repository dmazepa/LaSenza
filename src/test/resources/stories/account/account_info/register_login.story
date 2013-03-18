Meta:

Narrative:
Customers can register or log in to the site

Scenario: (MA08) Allow customers remember his password.
Given I am on Login page.
When I use process forgot my password.
Then I get email with new password.
And I can log in with new password.

Scenario: (MA01) Customers can log in to his account.
Given I am on Login page.
When Passing successful authentication.
Then I get My Account: Dashboard page with logged in status.

Scenario: (MA02) Allow customers use his cookie during using Site.
Given I am on Login page.
And Check-box Remember Me is checked.
When I log in.
Then After the session cookie expires, "Not <First Name> <Last Name>" link displays in the header.

Scenario: (MA03) Give to customer detail information about Remember Me functionality.
Given I am on Login page.
When I click on link What This?
Then A light box displays that provides users with an explanation for the form element.

Scenario: (MA04) Allow users create account.
Given I am on Login page.
When I use process to create account.
Then I get My Account: Dashboard page with logged in status.
And I get confirmation email.