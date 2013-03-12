package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class AddToCartConfigurableQvSteps {

    @Steps
    UserSteps user

    @When("Set multiple product configurations QV.")
    public void set_multiple_product_conﬁgurations_QV() {
        user.set_and_store_multiple_product_conﬁgurations_QV(2, 2, 1)
        user.set_and_store_multiple_product_conﬁgurations_QV(3, 3, 1)
    }

    @When("I click Add to Cart button QV configurable.")
    public void click_add_to_cart_QV() {
        user.choose_and_store_configurable_options_QV()
        user.click_add_to_cart_button_configurable_QV()
    }

    @Then("Each configuration will appear as its own line item in the mini-cart and shopping cart from QV.")
    public void assert_multiple_product_added_to_cart_and_mini_cart() {
        user.assert_multiple_product_added_to_mini_cart_from_QV()
        user.open_shopping_cart()
        user.assert_multiple_product_added_to_shopping_cart_from_QV()
    }

    @Then("Item don't add to cart configurable QV.")
    public void assert_item_not_added() {
        user.assert_item_not_added("The maximum quantity")
    }
}
