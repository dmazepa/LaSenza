Meta:

Narrative:
Product modules

Scenario: User can open QW from CLP
Given I am on SubCategory page as User.
When I roll mouse over the product image.
Then Highlights quick view button.
When I click on quick view button.
Then Pop-up displays.

Scenario: Users allow view simple products images in different colors from CLP.
Given I am on Collection landing page as User.
When I click on color swatch.
Then Product image replaces with a new image displaying the product in the selected color.

Scenario: Users allow view configurable products with more than 7 images in different colors from CLP.
Given I am on collection page as User.
When I click on View All Colors(#).
Then Popup displays with # of the color swatches loaded into it.
When When he select some color.
Then Product image replaces with a new image displaying the product in the selected color.