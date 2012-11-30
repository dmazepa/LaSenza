Meta:

Narrative:
As manager I want to configurate slider via admin panel.

Scenario: As manager I edit slider content
Given I am in admin panel
When  I create new banner
Then  I have added him to slider
And I should see one more image for rotating carousel on home page

Scenario: Controls at the bottom of the carousel allow users to manually move from image to image
Given I am on home page
When I click controls in the bottom of the carousel
Then Images vary from one to another