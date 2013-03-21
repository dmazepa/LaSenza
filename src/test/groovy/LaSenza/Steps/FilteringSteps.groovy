package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class FilteringSteps {

    @Steps
    UserSteps user

    @Given("I can see attribute refinements, number of products associated with each category appears near name.")
    public void assert_refinements_with_number_of_products(){
        user.assert_refinements_with_number_of_products()
    }

    @Given("Number of products associated with attribute color swatcher does not shows.")
    public void assert_refinements_colors_have_no_number_of_products(){
        user.assert_refinements_colors_have_no_number_of_products()
    }

    @When("Clicking an attribute refinement Size")
    public void click_refinement_size(){
        user.cLPage.set_qty_pages_before()
        user.click_refinement_size()
    }

    @Then("Its associated check-box places it in the Currently Shopping By list.")
    public void assert_refinement_size_checked_and_added_to_shopping_by(){
        user.assert_refinement_size_checked_and_added_to_shopping_by()
    }

    @Then("Dynamically filters both the list of remaining attribute refinements and the list of products returned")
    public void assert_new_list_of_products(){
        user.assert_qty_of_pages_recalculated()
    }

    @When("Clicking consistently on attribute refinement Color swatcher.")
    public void click_on_color_swatch_attribute(){
        user.click_on_color_swatch_refinement()
    }

    @Then("Its associated check-box for color places it in the Currently Shopping By list.")
    public void assert_selected_color_swatch_attribute(){
        user.assert_selected_color_swatch_attribute()
    }

    @When("Clicking consistently on attribute refinement Price.")
    public void select_price_boundaries(){
        user.select_price_boundaries()
    }

    @Then("Its associated check-box price places it in the Currently Shopping By list.")
    public void assert_selected_price(){
        user.assert_selected_price()
    }

}
