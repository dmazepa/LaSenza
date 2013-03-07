package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class AddToCartSimpleQvSteps {

    @Steps
    UserSteps user

    @Given("I am on QV with simple product.")
    public void open_QV_simple() {
        user.opens_CLP("sale")
        user.open_quick_view(1)
    }

    @When("I click Add to Cart button QV.")
    public void click_add_to_cart_button_QV_simple() {
        user.click_add_to_cart_button_QV()
    }

    @Then("Added items appears first in the list of Mini-Cart items.")
    public void assert_simple_added_to_cart() {
        user.assert_simple_added_to_cart()
    }
}
