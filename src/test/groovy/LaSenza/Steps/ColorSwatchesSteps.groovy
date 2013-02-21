package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class ColorSwatchesSteps {

    @Steps
    UserSteps user

    @When("I hovers my mouse over a color swatch.")
    public void hover_on_color_swatch() {
        user.hover_on_color_swatch()
    }

    @Then("Larger image displays in an overlay.")
    public void assert_larger_image() {
        user.assert_larger_image()
    }

    @When("I clicks a color swatch.")
    public void click_on_color_swatch() {
        user.click_on_color_swatch_pdp()
    }

    @Then("The product image changes to display the color variant selected (when available).")
    public void assert_main_image_changed() {
        user.assert_main_image_changed()
    }
}
