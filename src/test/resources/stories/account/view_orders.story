Meta:

Narrative:
Users can view information about orders.

Scenario: Allow users find order information by order number, email and last name.
Given I am on Login page.
When I enter correct information about order.
Then I get Order Information page.

Scenario: Allow users find order information by order number, zip code and last name.
Given I am on Login page.
When I enter correct information about order.
Then I get Order Information page.

Scenario: Show customers appropriate message if he have not placed orders.
Given I am on My Orders page.
And I have not placed orders.
Then Instead table with orders I get message "You have placed no orders".

Scenario: Allow customers view details about order.
Given I am on My Orders page.
When I click on View Order.
Then I get Order Information page.

Scenario: Allow customers view details about order.
Given I am on My Orders page.
When I click on View Order, that placed with credit cart payment.
Then I get Order Information page.
And I see, that order placed with credit cart payment.

Scenario: Allow customers view additional details about order.
Given I am on My Orders page.
When I click on View Order, that has admin comment and used discount.
Then I get Order Information page.
And I see comments posted by Admin.
And I see Pricing - Line Items.

Scenario: Send customers email when order invoiced or shipped and show additional information.
Given I am on Order Information page with complete order.
Then I can see additional tabs.
And I can see quantity shipped displays for each product.
And I can view Tracking information.
And I see emails in my mail box.

Scenario: Customers can create Return for order.
Given I am on Order Information page with complete order.
When I click on link Return.
Then I get New Return page.