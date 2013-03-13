Meta:

Narrative:
Allow customers view and edit their Account information.

Scenario: (MA09) Customers can navigate in their accounts using left navigation.
Given I am on My Account: Dashboard page.
When I click on any tab in left navigation.
Then I get appropriate page.

Scenario: (MA10) Customers can navigate to My orders page by link View All.
Given I am on My Account: Dashboard page.
When I click on View All link.
Then I get My orders page.

Scenario: (MA11) Customers can navigate to My order detail page by link View Order.
Given I am on My Account: Dashboard page.
When I click on View Order link.
Then I get My Orders Details page.

Scenario: (MA12) Allow Customers edit Account information.
Given I am on My Account: Dashboard page.
When I click on Edit link in Account information section.
Then I get Account Information page, where name, last name and email address are pre-populated from stored account information.
Then I can change it.

Scenario: (MA13) Allow Customers change password.
Given I am on My Account: Dashboard page.
When I click on Change Password link in Account information section.
Then I get Account Information page with Change Password check-box marked and additional form fields for changing a user's password.
And I can change password.

Scenario: (MA14) Allow customers view marketing preferences and edit them.
Given I am on My Account: Dashboard page.
And See My marketing preferences.
When I click on Edit link in Marketing Preferences block.
Then I get My marketing preferences page, where I can edit them.

Scenario: (MA15) Show special message or customers that does not have default billing, shipping or mailing address.
Given I am on My Account: Dashboard page.
And I do not have default billing, shipping or mailing address.
Then I can see message "You have not set a default <billing/shipping/mailing> address."

Scenario: (MA16) Allow customers manage their default addresses.
Given I am on My Account: Dashboard page.
When I click on Manage Addresses link.
Then I get Address Book page.

Scenario: (MA17) Allow customers edit their default addresses.
Given I am on My Account: Dashboard page.
When I click on Edit Address link for different default addresses.
Then I get edit Address page.

Scenario: (MA18) Allow Users add new addresses.
Given I am on Address Book page.
When I click on Add New Address button.
Then I get Add Address page, where ﬁrst name and last name are pre-populated from stored account information.
And I can add it.

Scenario: (MA19) Allow customers edit default addresses from Address Book page.
Given I am on Address Book page.
When I click on link Change default address.
Then I get Edit Address page with pre-populated fields.
And I can be sure that is this kind of default address.
And I can change address.

Scenario: (MA20) Allow customers edit additional addresses from Address Book page.
Given I am on Address Book page.
When I click on link Edit Address.
Then I get Edit Address page with pre-populated fields.
And Set it as default address.
And I can change address.

Scenario: (MA21) Allow customers delete address.
Given I am on Address Book page.
When I click Delete Address link.
Then Conﬁrmation popup appears.
And I can confirm or refuse deletion.

Scenario: (MA22) Allow customers set default billing, shipping or mailing adderss.
Given I am on Address Book: Edit Address page
Then If the address is already set as the default billing, shipping and/or mailing address, the corresponding checkbox does not appear. Instead, messaging simply reads: "Default Billing Address," "Default Shipping Address," and/or "Default Mailing Address."

Scenario: (MA23) Allow customers edit addersses.
Given I am on Address Book: Edit Address page
When I change adess and click Save Address button.
Then Leads to "Address Book," which displays the updated information. Confirmation message reads: "The address has been saved."

Scenario: (MA24) Allow customers add addersses.
Given I am on Address Book: Add Address
When I type data into fields and click Save Address button.
Then Leads to "Address Book," which displays the new address. Confirmation message reads: "The address has been saved."
