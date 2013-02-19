package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class AddToCartSimpleQvSteps {

    @Steps
    UserSteps user

    @Given("I am on QW with simple product.")
    public void open_qv_simple(){
        user.opens_CLP("sale")
        user.open_quick_view(1)
    }

    @When("I click Add to Cart button QV.")
    public void click_add_to_cart_button_qv_simple(){
        user.click_add_to_cart_button_qv()
    }

    @Then("Added items appears ﬁrst in the list of Mini-Cart items.")
    public void assert_simple_added_to_cart(){
        user.assert_simple_added_to_cart()
    }
}
