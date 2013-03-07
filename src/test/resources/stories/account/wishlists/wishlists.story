Meta:

Narrative:
Customers can view and edit information about wishlists.

Scenario: (MA44) Customers see default wislist, if any item were not added before.
Given I am on My Wishlists tab with no items in wishlist.
Then Default wishlist view before items have been added. Users can create new wishlists, but until they do so, items can only be added to this default wishlist. The default wishlist cannot be deleted.

Scenario: (MA45) Customers can edit wishlists attributes.
Given I am on My Wishlists tab with several wish lists.
When I edit wish list attributes: publicity and name and click savebutton.
Then It Update the profile and a confirmation message ppears above the wishlist name: "Wishlist "<name>" was successfully saved."

Scenario: (MA46) Customers can create new wishlists.
Given I am on My Wishlists tab.
When I click button "Create new Wish List"
Then Opens a light box allowing the user to enter a name for the wishlist. Save: New wishlist is in view and a confirmation message appears above the wishlist name: "Wishlist "<name>" was successfully saved." The default wishlist is set to Private.

Scenario: (MA47) Customers can delete wishlists, except default ewish list.
Given I am on My Wishlists tab with several wish lists.
When I click button "Create new Wish List"
Then Delete Wishlist button appears in the lower left of the table. Unlike the default wishlist, new wishlists can be deleted.

Scenario: (MA48) Customers can edit publicity for wishlists.
Given I am on My Wishlists tab with several wish lists.
When I open wish list and change it publicity.
Then Message box informs users whether the wishlist is public or private. If the user chooses to make a wishlist public, the message box reads: "This wishlist is publicly visible. edit" (Edit link opens light box - see Note 2)

Scenario: (MA49) Users has access for public wish lists.
Given I am on My Wishlists Login page.
When I search for public wish list
Then Public wishlists can be accessed by anyone via the Wishlist Search widget.

Scenario: (MA50) Customers can create new wishlists through select "Select Wish List".
Given I am on My Wishlists tab.
When I choose "Create wish list" from select.
Then This drop-down lets a user access other wishlists under the account. "Create New Wishlist" is also an option and acts the same as the "Create New Wishlist" button.

Scenario: (MA51) Customers can find public wishlists by name.
Given I am on My Wishlists tab.
When I perform search wish list using firstname and lastname of customer.
Then Leads to "4.10.6: My Wishlist: Search Results." Shows all wishlists that have been linked to the name with which the user searched.

Scenario: (MA52) Customers can find public wishlists by email.
Given I am on My Wishlists tab.
When I perform search wish list using email of customer.
Then Leads to "4.10.6: My Wishlist: Search Results." Shows all wishlists that have been linked to the  email with which the user searched.

Scenario: (MA53) Customers can add product to wishlists.
Given I am on PDP.
When Add product to wish list.
Then He or she is taken to the My Wishlist page. Upon arriving at the My Wishlist page, a confirmation message appears that confirms the item was added to the wishlist and provides a link to continue shopping (which leads back to the last page the user visited).

Scenario: (MA54) User can add product to wishlists.
Given I am on PDP.
When Add product to wish list.
Then If not logged in, the user is asked to do so or register first.  Upon arriving at the My Wishlist page, a confirmation message appears that confirms the item was added to the wishlist and provides a link to continue shopping (which leads back to the last page the user visited).

Scenario: (MA55) Customers can select all products in Wish List.
Given I am on My Wishlists tab with wishlist that has items.
When Check box select all items in the wishlist.
Then All items were selected.

Scenario: (MA56) Customers can copy selected products to another Wish List.
Given I am on My Wishlists tab with wishlist that has items.
When I selected items using the checkboxes along the left of the table and copy all those items to another wishlist by clicking an option within the "Copy to Wishlist" drop-down menu.
Then A confirmation message appears: "<#> items were copied to <WIshlist Name>: <product name>, <product name>,<product name>." The user is not redirected to the specified wishlist page.

Scenario: (MA57) Customers can't copy products, if he or she did not select them before.
Given I am on My Wishlists tab with wishlist that has items.
When I has not selected items and tries to click an option within the drop-down menu "Copy to Wishlist" .
Then A popup appears: "You must select items to copy."

Scenario: (MA58) Customers can move selected products to another Wish List.
Given I am on My Wishlists tab with wishlist that has items.
When I selected items using the checkboxes along the left of the table and copy all those items to another wishlist by clicking an option within the "Move to Wishlist" drop-down menu.
Then A confirmation message appears: "<#> items were successfully moved to <WIshlist Name>: <product name>, <product name>,<product name>." The user is not redirected to the specified wishlist page.

Scenario: (MA59) Customers can't move products, if he or she did not select them before.
Given I am on My Wishlists tab with wishlist that has items.
When I has not selected items and tries to click an option within the drop-down menu "Move to Wishlist" .
Then A popup appears: "You must select items to move."

Scenario: (MA60) Customers can enter comments for each itemin wish list.
Given I am on My Wishlists tab with wishlist that has items.
When I click within this field.
Then The following text appears: "Please, enter your comments…" with a cursor appearing after the ellipses. A scroll bar will appear if the user enters more text than can appear within the default container size. Also, users can manually expand the size of the container by clicking and dragging the hash marks in the lower right corner.

Scenario: (MA61) Customers can move products on Product Level to another Wish List.
Given I am on My Wishlists tab with wishlist that has items.
When I click an option within the "Move to Wishlist" drop-down menu related to some product.
Then A confirmation message appears: "<Product Name> was successfully moved to <Wishlist Name>." The user is not redirected to the specified wishlist page.

Scenario: (MA62) Customers can copy products on Product Level to another Wish List.
Given I am on My Wishlists tab with wishlist that has items.
When I click an option within the "Copy to Wishlist" drop-down menu related to some product.
Then A confirmation message appears: "<Product Name> was successfully copied to <Wishlist Name>." The user is not redirected to the specified wishlist page.

Scenario: (MA63) Customers can view product options on Product Level.
Given I am on My Wishlists tab with wishlist that has items.
When I hover on link "View details".
Then Displays a popup that lists the option details specified by the user (e.g. Size: Small). This link only appears if a user has actually specified options for the item (which is not a mandatory step to add to wishlist).

Scenario: (MA64) Customers can edit product options on Product Level.
Given I am on My Wishlists tab with wishlist that has items.
When I click on link "Edit" and change product options on PDP where display a link to "Update Wishlist."
Then Wishlist is updated and the user is directed back to the wishlist page. A confirmation message appears: "<Product Name> has been updated in your wishlist."

Scenario: (MA65) Customers see "Out of stock" message and can't see Add to cart button for out of stock items.
Given I am on My Wishlists tab with wishlist that has items and one of them is out of stock.
Then Message "Out of stock" appears and the "Add to Cart" button is not available for that particular item.

Scenario: (MA66) Customers can't see price or quantity field for grouped products.
Given I am on My Wishlists tab with wishlist that has grouped product.
Then Grouped products will not display a price or quantity field on the wishlist page. The "View Details" link only appears if a user has specified quantities for the item(s).  (Phase 2)

Scenario: (MA67) Customers can't see products do not list a specific price for bundle products - even if product options were specified.
Given I am on My Wishlists tab with wishlist that has bundle product.
Then Bundle products do not list a specific price - even if product options were specified. The wishlist only displays the bundle range. The "View Details" link only appears if a user has specified options for the item(s) or if the product has default options.

Scenario: (MA68) Customers can add comments and edit qty.
Given I am on My Wishlists tab with wishlist that has items.
When I add comment and edit qty for some product and click "Update Wishlist" button.

Scenario: (MA69) Customers can add all products from wish list to cart.
Given I am on My Wishlists tab with wishlist that has items.
When I click "Add All To Cart" button.
Then all items adds within the wishlist to the shopping cart and removes them from the wishlist. The user is not redirected to the shopping cart page.

Scenario: (MA70) Customers can share wish list for other users.
Given I am on My Wishlists tab with privat wishlist that has items.
When I click "Share WishList" button and on share Wish List pagefill all fields and click "Share WishList" button.
Then It sends an email to the designated recipients. The user is then redirected back to the "My Wish List" page and a confirmation message appears: "Your Wishlist has been shared." Private wishlists can only be viewed within the user's account or via a direct link that the user can send to whomever they choose by using the "Share Wishlist" feature.  View All Wishlist Items link in email leads to View Wishlist page (Guest)."

Scenario: (MA71) User can login from My Wish List Login Page.
Given I am on Wish list Login Page.
When I log in.
Then Upon successful authentication, leads to " No Items/New Wishlist"

Scenario: (MA72) User can create account from My Wish List Login Page.
Given I am on Wish list Login Page.
When I create account.
Then Leads to "Create an Account." Once account is created, redirects to "No Items/New Wishlist."

Scenario: (MA73) User can find wish lists from My Wish List Login Page.
Given I am on Wish list Login Page.
When I perform search wish lists by first and last name.
Then Leads to "My Wishlist: Search Results."

Scenario: (MA74) User can find wish lists from My Wish List Login Page.
Given I am on Wish list Login Page.
When I perform search wish lists by email.
Then Leads to "My Wishlist: Search Results.

Scenario: (MA75) User can view details about wish list from My Wishlist: Search Results page.
Given I am on My Wishlist: Search Results page with some result.
When I click on link "View"
Then Leads to "My Wishlist: View Wishlist - Guest." Where I can click link "Back" and return.

Scenario: (MA76) User can perform new search from My Wishlist: Search Results page.
Given I am on My Wishlist: Search Results page with some result.
When I perform search wish lists.
Then I get appropriate result.

Scenario: (MA77) User can add to cart products from searched wish list.
Given I am on My Wishlist: View Wishlist - Guest page.
When I click "Add To Cart" button.
Then Adds the selected items to the shopping cart. This does not update the quantity field in the wishlist.