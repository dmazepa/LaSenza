Meta:

Narrative:
Users can view information about orders.

Scenario: (MA05) Allow users find order information by order number, email and last name.
Given I am on Login page.
When I enter correct information about order.
Then I get Order Information page.

Scenario: (MA06) Allow users find order information by order number, zip code and last name.
Given I am on Login page.
When I enter correct information about order.
Then I get Order Information page.

Scenario: (MA07) Show customers appropriate message if he have not placed orders.
Given I am on My Orders page.
And I have not placed orders.
Then Instead table with orders I get message "You have placed no orders".

Scenario: (MA25) Allow customers view details about order.
Given I am on My Orders page.
When I click on View Order.
Then I get Order Information page.

Scenario: (MA26) Allow customers view details about order.
Given I am on My Orders page.
When I click on View Order, that placed with credit cart payment.
Then I get Order Information page.
And I see, that order placed with credit cart payment.

Scenario: (MA27) Allow customers view additional details about order.
Given I am on My Orders page.
When I click on View Order, that has admin comment and used discount.
Then I get Order Information page.
And I see comments posted by Admin.
And I see Pricing - Line Items.

Scenario: (MA28) Send customers email when order invoiced or shipped and show additional information.
Given I am on Order Information page with complete order.
Then I can see additional tabs.
And I can see quantity shipped displays for each product.
And I can view Tracking information.
And I see emails in my mail box.

Scenario: (MA29) Customers can create Return for order.
Given I am on Order Information page with complete order.
When I click on link Return.
Then I get New Return page.

Scenario: (MA30) Customers can print invoice.
Given I am on Order Information page with complete order.
When I click on link print invoice.
Then Link opens a new browser window displaying a printable image of the invoice along with the browser's print options.

Scenario: (MA31) Customers can view tracking information.
Given I am on Order Information page with complete order.
When Click onTrack Shipment or Track All Shipment
Then This section and related links appear only if tracking information has been provided in the Admin. Links open a new browser window that displays tracking information.

Scenario: (MA32) Customers can view tracking information.
Given I am on Order Information page with complete order.
When Click on Print Shipment  or Print Shipment.
Then Link opens a new browser window displaying a printable image of the shipment information along with the browser's print options.

Scenario: (MA33) Allow customers view details about return.
Given I am on Order Information page with complete order.
When I open tab "Returns"
Then I get page "4.17.3 My Returns - View Return."

Scenario: (MA34) Allow customers view details about refunds.
Given I am on Order Information page with complete order, that has refunds.
When I open tab "Refunds"
Then Special tab appears when a refund has been issued for a return.

Scenario: (MA35) Allow customers to print details about refunds.
Given I am on Order Information page with complete order, that has refunds.
When I click on button "Print refund" or "Print all refunds".
Then Link opens a new browser window displaying a printable image of the refund along with the browser's print options.

Scenario: (MA36) Allow customers view details about invoices.
Given I am on Order Information page with complete order, that has invoices.
When I open tab "Invoices"
Then Special tab appears with information about invoice.

Scenario: (MA37) Allow customers to print details about invoices.
Given I am on Order Information page with complete order, that has invoices.
When I click on button "Print invoices" or "Print all invoices".
Then Link opens a new browser window displaying a printable image of the refund along with the browser's print options.

Scenario: (MA38) Allow customers view details about shipments.
Given I am on Order Information page with complete order, that has ishipments.
When I open tab "Shipments"
Then Special tab appears with information about shipments.

Scenario: (MA39) Allow customers to print details about shipments.
Given I am on Order Information page with complete order, that has shipments.
When I click on button "Print shipments" or "Print all shipments".
Then Link opens a new browser window displaying a printable image of the refund along with the browser's print options.

Scenario: (MA40) Allow customers to track shipments.
Given I am on Order Information page with complete order, that has tracking shipments.
When I click on button "Track shipments" or "Track all shipments".
Then This section and related links appear only if tracking information has been provided in the Admin. Links open a new browser window that displays tracking information (see "4.05.3 Order Information - Complete").

Scenario: (MA41) Allow customers to view details about return.
Given I am on Order Information page with complete order, that has return.
When I click on "View Return" link.
Then I get "4.17.3 My Returns - View Return."

Scenario: (MA42) Allow customers to print details about refunds.
Given I am on Order Information page with complete order, that has refunds.
When I click on button "Print refundss" or "Print all refunds".
Then Link opens a new browser window displaying a printable image of the refund along with the browser's print options.