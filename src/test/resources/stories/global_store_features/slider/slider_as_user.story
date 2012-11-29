Meta:

Narrative:
As user I want to see rotating carousel on home page and be able to manipulate it.

Scenario: Slider rotates every 5 sec and placeholder shows position
Given  I am on home page
Then I should see carousel cycles automatically through a series of hero images at 5 second intervals with a smooth (fade in / fade out) transition between carousel changes
And A placeholder appears in the bottom of the carousel to indicate position within the carousel

Scenario: Controls at the bottom of the carousel allow users to manually move from image to image
Given  I am on home page
Then I click controls in the bottom of the carousel
And Images vary from one to another