package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class AddToCartConfigurableQwSteps {

    @Steps
    UserSteps user

    @When("Set multiple product conﬁgurations QV.")
    public void set_multiple_product_conﬁgurations_QV(){
        user.set_and_store_multiple_product_conﬁgurations_qv(2, 1, 2)
        user.set_and_store_multiple_product_conﬁgurations_qv(3, 2, 1)
    }

    @When("I click Add to Cart button QV configurable.")
    public void click_add_to_cart_QV(){
        user.choose_and_store_configurable_options_qv()
        user.click_add_to_cart_button_configurable_qv()
    }

    @Then("Each conﬁguration will appear as its own line item in the mini-cart and shopping cart from QV.")
    public void assert_multiple_product_added_to_cart_and_mini_cart(){
        user.assert_multiple_product_added_to_mini_cart_from_qv()
        user.open_shopping_cart()
        user.assert_multiple_product_added_to_shopping_cart_from_qv()
    }
}
