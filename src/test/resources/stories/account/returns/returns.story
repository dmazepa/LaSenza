Meta:

Narrative:
Customers can view and edit information about returns.

Scenario: (MA78) Customer can view tab "My Returns" only if return requests have been submitted for the account.
Given I am on My Account: Dashboard page.
Then The My Returns subcategory appears in the left navigation panel only if return requests have been submitted for the account.

Scenario: (MA79) Customer can view return details from tab "My Returns".
Given I am on My Account: tab "My Returns" .
When I click on link "View Return"
Then Leads to "My Returns - View Return."

Scenario: (MA80) Customer can create return with more than 1 items.
Given I am on My Returns: New Return  from Order View Complite Guest page.
When I enter correct information  and add more items to return.
Then Displays another set of Return form fields and provides the ability to delete the additional return. Submits the return and then leads to "My Returns." The following confirmation message appears: "Return <#> has been submitted successfully."

Scenario: (MA81) Customer can create and view comments related to return.
Given I am on My Returns: View Return.
When I add comment.
Then Adds the entered text to the Comment Section on this page and updates the RMA section in Admin. If the user or a CSR leaves a comment regarding this return, it will appear in this section.