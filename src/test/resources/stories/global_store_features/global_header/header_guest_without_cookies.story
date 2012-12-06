Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: Welcome message for guest.
Given I am on home page.
Then I should string Welcome!

Scenario: Link Log In redirects to Login page.
Given I am on home page.
When I click on link Log In.
Then I should redirects to Login page.

Scenario: Link Register redirects to the Account Creation page.
Given I am on Login page as guest.
When I click on link Register in header.
Then I should redirects to the Account Creation page.

Scenario: Link My Account redirects to the Login page.
Given I am on Account Creation page as guest.
When I click on link My Account.
Then I should redirects to the Login page.

Scenario: Link Wish List redirects to My Wish List Login page.
Given I am on Login page as guest.
When I click on link Wish List.
Then I should redirects to the My Wish List Login page.