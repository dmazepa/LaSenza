package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class CompactModeSteps {

    @Steps
    UserSteps user

    @When("Clicking the arrow to the right of the attribute title.")
    public void click_arrow_attribute_title() {
        user.click_arrow_attribute_title()
    }

    @Then("The arrow faces down when an attribute refinement group is expanded.")
    public void assert_attribute_refinement_expanded() {
        user.assert_attribute_refinement_expanded()
    }

    @Then("Faces to the right when collapsed.")
    public void assert_attribute_refinement_collapsed() {
        user.assert_attribute_refinement_collapsed()
    }
}
