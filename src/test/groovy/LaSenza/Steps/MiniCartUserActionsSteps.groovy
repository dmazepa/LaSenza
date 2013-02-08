package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class MiniCartUserActionsSteps {

    @Steps
    UserSteps user

    @When("Click on Product <Element>")
    public void click_on_element(String Element){
        user.click_on_element_in_mini_cart(Element)
    }

    @Then("I redirects to appropriate PDP.")
    public void assert_on_pdp(){
        user.assert_on_PDP()
    }

    @When("Click on link Edit Item.")
    public void click_on_link_edit_item(){
        user.click_on_link_edit_item()
    }

    @Then("I redirects to appropriate PDP and Add to Cart button has been replaced with an Update Cart button.")
    public void assert_on_pdp_with_button_update_cart(){
        user.assert_on_pdp_with_button_update_cart()
    }

    @Then("I can edit item.")
    @Pending
    public void assert_that_i_can_edit_item(){
        user.assert_that_i_can_edit_item()
    }
}
