Meta:

Narrative:
Header for customer with cookies enabled.

Scenario: Welcome message for guest with cookie enabled.
Given I am on home page as guest with cookies.
Then I should string Welcome <First Name>!

Scenario: Link Please Log In redirects to Login page.
Given I am on home page as guest with cookie enabled.
When I click on link Please Log In.
Then I should redirects to Login page.

Scenario: Link Not <First Name> <Last Name>? logs the user out and loads the default header state.
Given I am on Login page as guest with cookies.
When I click on link Not <First Name> <Last Name>?.
Then It logs me out.
And Load default header state.

Scenario: Link My Account redirects to the Login page.
Given I am on Home page as guest with cookie enabled.
When I click on link My Account.
Then I should redirects to the Login page.

Scenario: Link Wish List redirects to My Wish List Login page.
Given I am on Login page as guest with cookie enabled.
When I click on link Wish List.
Then I should redirects to the My Wish List Login page.