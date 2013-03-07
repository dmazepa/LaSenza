Meta:

Narrative:
Header for customer with cookies enabled.

Scenario: (GSF33) Welcome message for customer with cookie enabled.
Given I am on home page as customer with cookies.
When I did not have activity more than  set to cookie save.
Then I should see welcome msg "WELCOME BACK TEST TESTER"
Then I should see string "Please Login. Not Test Tester?"

Scenario: (GSF34) Link Please Log In redirects to Login page.
Given I am on home page as customer with cookie enabled.
When I click on link Please Log In.
Then I should redirects to Login page.

Scenario: (GSF35) Link Not <First Name> <Last Name>? logs the user out and loads the default header state.
Given I am on home page as customer with cookie enabled.
When I click on link Not Test Tester?.
Then It logs customer out.
And Load default header state.

Scenario: (GSF36) Link My Account redirects to the Login page.
Given I am on home page as customer with cookie enabled.
When I click on link My Account.
Then I should redirects to Login page.

Scenario: (GSF37) Link Wish List redirects to My Wish List Login page.
Given I am on home page as customer with cookie enabled.
When I click on link Wish List.
Then I should redirects to the My Wish List Login page.

