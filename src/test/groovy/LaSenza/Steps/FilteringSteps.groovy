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
        user.click_refinement_size()
    }

    @Then("Its associated check-box places it in the Currently Shopping By list.")
    public void assert_refinement_size_checked_and_added_to_shopping_by(){
        user.assert_refinement_size_checked_and_added_to_shopping_by()
    }

}