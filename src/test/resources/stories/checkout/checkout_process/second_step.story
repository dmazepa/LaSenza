Meta:

Narrative:
Show to user summary information on second checkout step.

Scenario: Allow users come back to first step to edit order information.
Given I am on second step of checkout process with valid information.
When I click 4 different links Edit.
Then I redirects to the first step of checkout.

Scenario: Allow users submit order information.
Given I am on second step of checkout process with valid information.
When I click Submit button.
Then I get order confirmation page.

Scenario: Disallow users submit order with wrong information.
Given I am on second step of checkout process with invalid information.
When I click Submit button.
Then Returns appropriate message.