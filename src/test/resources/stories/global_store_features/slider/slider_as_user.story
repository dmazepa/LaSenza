Meta:

Narrative:
As user I want to see rotating carousel on home page and be able to manipulate it.

Scenario: (GSF30) Slider rotates every 5 sec and placeholder shows position
Given I am on home page
When I should see carousel cycles automatically through a series of hero images at 5 second intervals with a smooth (fade in / fade out) transition between carousel changes
Then A placeholder appears in the bottom of the carousel to indicate position within the carousel

Scenario: (GSF31) Controls at the bottom of the carousel allow users to manually move from image to image
Given I am on home page
Then I click controls in the bottom of the carousel
