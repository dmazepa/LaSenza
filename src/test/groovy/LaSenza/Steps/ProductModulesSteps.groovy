package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class ProductModulesSteps {

    @Steps
    UserSteps user

    @When("I roll mouse over the product image.")
    public void mouse_over_on_product_image() {
        user.mouse_over_on_product_image(1)
    }

    @Then("Highlights quick view button.")
    public void quick_view_button_highlights() {
        user.assert_quick_view_button()
    }

    @When("I click on quick view button.")
    public void click_quick_view_button() {
        user.click_on_button_quick_view(1)
    }

    @Then("Pop-up displays.")
    public void assert_quick_view_module_opened() {
        user.assert_quick_view_module_opened()
    }

    @When("I click on color swatch.")
    public void click_on_color_swatch() {
        user.click_on_color_swatch(1)
    }

    @Then("Product image replaces with a new image displaying the product in the selected color.")
    public void assert_product_image_replaced_with_new_image_CLP() {
        user.assert_image_replaced_CLP()
    }

    @When("I click on View All Colors(#).")
    public void click_on_view_all_colors() {
        user.click_on_view_all_colors()
    }

    @Then("Popup displays with # of the color swatches loaded into it.")
    public void assert_pop_up_color_swatches() {
        user.assert_pop_up_color_swatches()
    }

    @When("When he select some color.")
    public void select_color_in_pop_up_color_swatches() {
        user.select_color_in_pop_up_color_swatches()
    }
}
