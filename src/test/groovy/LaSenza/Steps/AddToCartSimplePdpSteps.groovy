package LaSenza.Steps

import LaSenza.steps.AdminPanelSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class AddToCartSimplePdpSteps {

    @Steps
    UserSteps user

    @Steps
    AdminPanelSteps admin

    @Given("I am on PDP with simple product.")
    public void open_pdp_simple() {
        user.open_pdp(1472)
    }

    @When("I click Add to Cart button.")
    public void click_add_to_cart_button() {
        user.click_add_to_cart_button_expect_error()
    }

    @When('I fill quantity "$qty" greater than the inventory available.')
    public void fill_qty(String qty) {
        user.fill_qty(qty)
        user.store_state_of_total_price_and_qty()
    }

    @Then('Added items qty "$qty" and price "$price" appears ﬁrst in the list of Mini-Cart items.')
    public void assert_item_added_to_mini_cart(String qty, String price) {
        user.assert_qty_and_price_added_to_mini_cart(qty, price)
    }

    @Then("Mini cart slides down.")
    public void assert_mini_cart_appears() {
        user.assert_mini_cart_appears()
    }

    @Then("Item don't add to cart.")
    public void assert_item_not_added() {
        user.assert_item_not_added("The maximum quantity")
    }

    @Then('The qty "$qty" and order total "$price" are updated to reflect the addition.')
    public void assert_qty_and_price_added_in_header(String qty, String price) {
        user.assert_qty_and_price_added_in_header(qty, price)
    }

    @Then('Added items qty "$qty" and price "$price" appears first in the list of Mini-Cart items.')
    public void assert_item_in_mini_cart(String qty, String price) {
        user.assert_qty_and_price_added_to_mini_cart(qty, price)
    }

}
