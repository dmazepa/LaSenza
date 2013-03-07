Meta:

Narrative:
Customers can view and sent invatations.

Scenario: (MA82) Customers can view and sent invatations.
Given I am on My Ivatations page.
When I click "Send Invitations" button and getSend Invitations pag, where I fill all requered fields and click "Submit" button.
Then An admin-generated email is sent to recipients inviting them to create an account.

Scenario: (MA83) User can view orders from Order View Complite Guest page.
Given I am on Order View Complite Guest page.
When I click on View Another Order link
Then Leads to " User Account - Login."