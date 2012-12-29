package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class AddToCartSimplePdpSteps {

    @Steps
    UserSteps user

    @Given("I am on PDP with simple product.")
    public void open_pdp_simple(){
        user.open_pdp(2213)
    }

    @When("I click Add to Cart button.")
    public void click_add_to_cart_button(){
        user.click_add_to_cart_button_pdp()
    }

    @When('I fill quantity "$qty" greater than the inventory available.')
    public void fill_qty(String qty){
        user.fill_qty(qty)
        user.store_state_of_total_price_and_qty()
    }

    @Then('Added items qty "$qty" and price "$price" appears ﬁrst in the list of Mini-Cart items.')
    public void assert_item_added_to_mini_cart(String qty, String price){
        user.assert_qty_and_price_added_to_mini_cart(qty, price)
    }

    @Then("Mini cart slides down.")
    public void assert_mini_cart_appears(){
        user.assert_mini_cart_appears()
    }

    @Then("Item don't add to cart.")
    public void assert_item_not_added(){
        user.assert_item_not_added()
    }

    @Then('The quantity "$qty" and order total "$price" are updated to reﬂect the addition.')
    public void assert_qty_and_price_added_in_header(String qty, String price){
        user.assert_qty_and_price_added_in_header(qty, price)
    }

}
