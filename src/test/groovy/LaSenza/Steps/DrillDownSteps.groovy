package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class DrillDownSteps {

    @Steps
    UserSteps user

    @Given("I can see category refinements, number of products associated with each category appears near name.")
    public void assert_category_refinements_CLP() {
        user.assert_category_refinements_CLP()
    }

    @When("I click on category refinement.")
    public void click_on_category_refinements_CLP() {
        user.click_on_category_refinements_CLP()
    }

    @Then("It removes the value from its original location.")
    public void assert_category_refinements_removed_CLP() {
        user.assert_category_refinements_removed_CLP()
    }

    @Then("Places it in the Currently Shopping By list.")
    public void assert_category_refinements_appears_in_shop_by_list_CLP() {
        user.assert_category_refinements_appears_in_shop_by_list_CLP("Bras")
    }

    @Then("Dynamically filters both the list of attribute refinements and the list of products returned.")
    public void assert_CLP_and_left_navigation_updated() {
        user.assert_CLP_and_left_navigation_updated()
    }

    @Then("Category list disappears.")
    public void assert_category_list_disappeared() {
        user.assert_category_list_disappeared()
    }

    @When("I remove the refinement.")
    public void click_remove_category_refinement() {
        user.click_remove_category_refinement()
    }

    @Then("The list of categories display again.")
    public void assert_category_refinement_visible() {
        user.assert_category_refinement_visible()
    }
}
