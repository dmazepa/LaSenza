Meta:

Narrative:
Header for guest without cookies enabled.

Scenario: (GSF38) Welcome message for guest.
Given I am on home page.
Then I should see welcome msg "WELCOME!"

Scenario: (GSF39) Link Log In redirects to Login page.
Given I am on home page.
When I click on link Log In.
Then I should redirects to Login page.

Scenario: (GSF40) Link Register redirects to the Account Creation page.
Given I am on home page.
When I click on link Register in header.
Then I should redirects to the Account Creation page.

Scenario: (GSF41) Link My Account redirects to the Login page.
Given I am on home page.
When I click on link My Account.
Then I should redirects to the Login page.

Scenario: (GSF42) Link Wish List redirects to My Wish List Login page.
Given I am on home page.
When I click on link Wish List.
Then I should redirects to the My Wish List Login page.