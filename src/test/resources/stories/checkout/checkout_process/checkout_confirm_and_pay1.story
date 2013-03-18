Meta:

Narrative:
Show to user summary information on second checkout step.

Scenario: (CH32) Allow users come back to first step to edit order information.
Given I am on second step of checkout process with information, that I want to change.
When I click <element> link <counter> Edit.
Then I redirects to the first step of checkout.

Examples:
|element                |counter
|billing edit           |1
|shipping address edit  |2
|payment edit           |4
|other edit             |7
|shipping method edit   |5