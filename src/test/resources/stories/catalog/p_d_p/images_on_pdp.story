Meta:

Narrative:
Allow users to get more about product by view images.

Scenario: (CA01) I should see and can change main image for products with more then one image.
Given I am on PDP with more then one image.
When I choose thumbnail image.
Then I should see chosen image instead main.
And I can see more then one thumbnail image.

Scenario: (CA02) I shouldn't see thumbnail images on QV for product, that has one image.
Given I am on PDP with one image.
And I shouldn't see thumbnail imageso on PDP.
When I click on image.
Then Activates Magento's standard product zoom feature.

Scenario: (CA03) Allow user view in detail main image.
Given I am on PDP as User.
When I click on main image.
Then Two magniﬁcation overlays display.
When Moving the mouse outside of the main image box.
Then Zoom feature deactivates.