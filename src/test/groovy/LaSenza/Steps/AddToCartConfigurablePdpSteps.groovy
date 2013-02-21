package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class AddToCartConfigurablePdpSteps {

    @Steps
    UserSteps user

    @Given("I am on PDP with configurable product.")
    public void open_pdp_configurable() {
        user.delete_items_from_cart()
        user.open_pdp(1574)
    }

    @When("Set multiple product.")
    public void set_multiple_product() {
        user.set_and_store_multiple_product_conﬁgurations(2, 2, 2)
        user.set_and_store_multiple_product_conﬁgurations(3, 2, 3)
    }

    @Then('The quantity "$qty" and order total "$price" are updated to reflect the addition.')
    public void assert_item_in_header(String qty, String price) {
        user.assert_qty_and_price_added_in_header(qty, price)
    }

    @Then('Added items qty "$qty" and price "$price" appears first in the Shopping cart.')
    public void assert_item_in_shopping_cart(String qty, String price) {
        user.open_shopping_cart()
        user.assert_qty_and_price_added_to_shopping_cart(qty, price)
    }

    @When("I click Add to Cart button configurable.")
    public void click_add_to_cart_button() {
        user.choose_and_store_configurable_options()
        user.click_add_to_cart_button_pdp()
    }

    @Then("Each item will appear as its own line item in the mini-cart and shopping cart.")
    public void assert_multiple_product_added_to_cart_and_mini_cart() {
        user.assert_multiple_product_added_to_mini_cart()
        user.open_shopping_cart()
        user.assert_multiple_product_added_to_shopping_cart()
    }

    @Then("Item do not add to cart configurable.")
    public void assert_item_not_added_configurable() {
        user.assert_item_not_added("The requested quantity")
    }

}
