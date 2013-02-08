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

    @When("Click on link Remove Item.")
    public void click_on_link_remove_item_mini_cart(){
        user.store_state_of_total_price_and_qty()
        user.click_on_link_remove_item_mini_cart()
    }

    @When("Accept confirmation.")
    public void accept_confirmation_on_remove_item_mini_cart(){
        user.accept_confirmation_on_remove_item_mini_cart()
    }

    @Then("Product removes from shopping cart.")
    public void assert_product_deleted(){
        user.assert_product_deleted()
    }
}
